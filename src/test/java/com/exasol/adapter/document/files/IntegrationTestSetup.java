package com.exasol.adapter.document.files;

import static com.exasol.adapter.document.GenericUdfCallHandler.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeoutException;

import com.azure.storage.blob.BlobContainerClient;
import org.jetbrains.annotations.NotNull;

import com.exasol.adapter.document.UdfEntryPoint;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;
import com.exasol.bucketfs.Bucket;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.dbbuilder.dialects.DatabaseObject;
import com.exasol.dbbuilder.dialects.exasol.*;
import com.exasol.dbbuilder.dialects.exasol.udf.UdfScript;
import com.exasol.exasoltestsetup.ExasolTestSetup;
import com.exasol.exasoltestsetup.ServiceAddress;
import com.exasol.udfdebugging.UdfTestSetup;

import jakarta.json.*;
import lombok.Getter;
import lombok.Setter;

public class IntegrationTestSetup implements AutoCloseable {
    private static final String ADAPTER_JAR = "document-files-virtual-schema-dist-6.0.0-azure-blob-storage-1.0.0.jar";
    private final ExasolTestSetup exasolTestSetup;
    private final Connection connection;
    private final Statement statement;
    private final ExasolObjectFactory exasolObjectFactory;
    private final AdapterScript adapterScript;
    private final Bucket bucket;
    private final List<DatabaseObject> createdObjects = new LinkedList<>();
    private final AbsTestSetup absTestSetup;
    private final BlobContainerClient absContainer;
    private final UdfTestSetup udfTestSetup;
    @Getter
    @Setter
    private ConnectionDefinition connectionDefinition;

    public IntegrationTestSetup(final ExasolTestSetup exasolTestSetup, final AbsTestSetup absTestSetup,
            final BlobContainerClient absContainer)
            throws SQLException, BucketAccessException, TimeoutException, FileNotFoundException {
        this.exasolTestSetup = exasolTestSetup;
        this.absTestSetup = absTestSetup;
        this.absContainer = absContainer;
        this.connection = this.exasolTestSetup.createConnection();
        this.statement = this.connection.createStatement();
        this.statement.executeUpdate("ALTER SESSION SET QUERY_CACHE = 'OFF';");
        this.bucket = this.exasolTestSetup.getDefaultBucket();
        this.udfTestSetup = new UdfTestSetup(this.exasolTestSetup, this.connection);
        final List<String> jvmOptions = new ArrayList(Arrays.asList(this.udfTestSetup.getJvmOptions()));
        this.exasolObjectFactory = new ExasolObjectFactory(this.connection,
                ExasolObjectConfiguration.builder().withJvmOptions(jvmOptions.toArray(String[]::new)).build());
        final ExasolSchema adapterSchema = this.exasolObjectFactory.createSchema("ADAPTER");
        this.connectionDefinition = createConnectionDefinition();
        this.adapterScript = createAdapterScript(adapterSchema);
        createUdf(adapterSchema);
    }

    private static void createUdf(final ExasolSchema adapterSchema) {
        adapterSchema.createUdfBuilder("IMPORT_FROM_AZURE_BLOB_STORAGE_DOCUMENT_FILES")
                .language(UdfScript.Language.JAVA).inputType(UdfScript.InputType.SET)
                .parameter(PARAMETER_DOCUMENT_FETCHER, "VARCHAR(2000000)")
                .parameter(PARAMETER_SCHEMA_MAPPING_REQUEST, "VARCHAR(2000000)")
                .parameter(PARAMETER_CONNECTION_NAME, "VARCHAR(500)").emits()
                .bucketFsContent(UdfEntryPoint.class.getName(), "/buckets/bfsdefault/default/" + ADAPTER_JAR).build();
    }

    private ConnectionDefinition createConnectionDefinition() {
        final JsonObjectBuilder configJson = getConnectionConfig();
        return createConnectionDefinition(configJson);
    }
    //TODO:
    //creates the json connection config object
    public JsonObjectBuilder getConnectionConfig() {
        //final byte[] json = this.absTestSetup.getKeyFileAsJson();
        final JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        //final Optional<String> hostOverride = getHostOverride();
        //hostOverride.ifPresent(s -> objectBuilder.add("gcHost", s));
        return objectBuilder//
                .add("containerName", this.absContainer.getBlobContainerName())//
                .add("storageAccountConnectionString", this.absTestSetup.getStorageAccountConnectionString());
    }

    private JsonValue readJson(final byte[] json) {
        try (final ByteArrayInputStream inputStream = new ByteArrayInputStream(json);
                final JsonReader jsonReader = Json.createReader(inputStream);) {
            return jsonReader.readValue();
        } catch (final IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    public ConnectionDefinition createConnectionDefinition(final JsonObjectBuilder details) {
        return this.exasolObjectFactory.createConnectionDefinition("ABS_CONNECTION_" + System.currentTimeMillis(), "",
                "", toJson(details.build()));
    }

    private String toJson(final JsonObject configJson) {
        try (final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                final JsonWriter writer = Json.createWriter(outputStream)) {
            writer.write(configJson);
            return outputStream.toString(StandardCharsets.UTF_8);
        } catch (final IOException exception) {
            throw new UncheckedIOException("Failed to serialize connection settings", exception);
        }
    }

    private Optional<String> getHostOverride() {
        return this.absTestSetup.getHostOverride().map(address -> this.exasolTestSetup
                .makeTcpServiceAccessibleFromDatabase(ServiceAddress.parse(address)).toString());
    }

    private AdapterScript createAdapterScript(final ExasolSchema adapterSchema)
            throws BucketAccessException, TimeoutException, FileNotFoundException {
        this.bucket.uploadFile(Path.of("target", ADAPTER_JAR), ADAPTER_JAR);
        return adapterSchema.createAdapterScriptBuilder("FILES_ADAPTER")
                .bucketFsContent("com.exasol.adapter.RequestDispatcher", "/buckets/bfsdefault/default/" + ADAPTER_JAR)
                .language(AdapterScript.Language.JAVA).build();
    }

    @Override
    public void close() throws Exception {
        try {
            this.udfTestSetup.close();
            this.statement.close();
            this.connection.close();
            this.exasolTestSetup.close();
        } catch (final SQLException exception) {
            // at least we tried to close it
        }
    }

    public Statement getStatement() {
        return this.statement;
    }

    protected VirtualSchema createVirtualSchema(final String schemaName, final String mapping) {
        return createVirtualSchema(schemaName, mapping, this.connectionDefinition);
    }

    protected VirtualSchema createVirtualSchema(final String schemaName, final String mapping,
            final ConnectionDefinition connection) {
        final VirtualSchema virtualSchema = getPreconfiguredVirtualSchemaBuilder(schemaName)
                .connectionDefinition(connection)//
                .properties(getVirtualSchemaProperties(mapping)).build();
        this.createdObjects.add(virtualSchema);
        return virtualSchema;
    }

    @NotNull
    private Map<String, String> getVirtualSchemaProperties(final String mapping) {
        final Map<String, String> properties = new HashMap<>(Map.of("MAPPING", mapping));
        final String debugProperty = System.getProperty("test.debug", "");
        final String profileProperty = System.getProperty("test.jprofiler", "");
        if (!debugProperty.isBlank() || !profileProperty.isBlank()) {
            properties.put("MAX_PARALLEL_UDFS", "1");
        }
        if (System.getProperty("test.vs-logs", "false").equals("true")) {
            properties.put("DEBUG_ADDRESS", "127.0.0.1:3001");
            properties.put("LOG_LEVEL", "ALL");
        }
        return properties;
    }

    public void dropCreatedObjects() {
        for (final DatabaseObject createdObject : this.createdObjects) {
            createdObject.drop();
        }
        this.createdObjects.clear();
    }

    public Bucket getBucket() {
        return this.bucket;
    }

    public ExasolObjectFactory getExasolObjectFactory() {
        return this.exasolObjectFactory;
    }

    public VirtualSchema.Builder getPreconfiguredVirtualSchemaBuilder(final String schemaName) {
        return this.exasolObjectFactory.createVirtualSchemaBuilder(schemaName)
                .connectionDefinition(this.connectionDefinition).adapterScript(this.adapterScript);
    }
}
