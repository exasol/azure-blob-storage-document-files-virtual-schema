package com.exasol.adapter.document.files;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.*;
import java.nio.file.*;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;

import com.azure.core.util.BinaryData;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.exasol.adapter.document.files.abstestsetup.*;
import com.exasol.bucketfs.BucketAccessException;
import com.exasol.dbbuilder.dialects.DatabaseObjectException;
import com.exasol.dbbuilder.dialects.exasol.ConnectionDefinition;
import com.exasol.dbbuilder.dialects.exasol.VirtualSchema;
import com.exasol.exasoltestsetup.ExasolTestSetup;
import com.exasol.exasoltestsetup.ExasolTestSetupFactory;
import com.exasol.exasoltestsetup.testcontainers.ExasolTestcontainerTestSetup;

@Tag("integration")
@Testcontainers
class AbsDocumentFilesAdapterIT extends AbstractDocumentFilesAdapterIT {
    private static IntegrationTestSetup setup;
    private static TestContainer testContainer;
    private static AbsTestSetup absTestSetup;

    @BeforeAll
    static void beforeAll() throws Exception {
        final ExasolTestSetup exasolTestSetup = new ExasolTestSetupFactory(
                Path.of("cloudSetup/generated/testConfig.json")).getTestSetup();
        //if this file doesn't exist we just get a local exasol test container setup back
        //ABS - and this will return a 'local' azure blob storage, using the azurite emulator.
        absTestSetup = getAbsTestSetup(exasolTestSetup);
        //this will set up a new Azure Blob Storage test container for us
        testContainer = new TestContainer(absTestSetup);
        setup = new IntegrationTestSetup(exasolTestSetup, absTestSetup, testContainer.getBlobContainerClient());
    }

    @NotNull
    private static AbsTestSetup getAbsTestSetup(final ExasolTestSetup exasolTestSetup) {
        if (exasolTestSetup instanceof ExasolTestcontainerTestSetup) {
            return new LocalAbsTestSetup();
        } else {
            return new OnlineAbsTestSetup();
        }
    }

    @AfterAll
    static void afterAll() throws Exception {
        testContainer.close();
        setup.close();
        absTestSetup.close();
    }

    @AfterEach
    void after() {
        testContainer.empty();
        setup.dropCreatedObjects();
    }

    @Override
    protected Statement getStatement() {
        return setup.getExasolStatement();
    }

    @Override
    protected void uploadDataFile(final Supplier<InputStream> fileContent, final String fileName) {
        try (final InputStream inputStream = fileContent.get()) {
            final Path tempFile = Files.createTempFile("data-file", ".data");
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
            uploadDataFile(tempFile, fileName);
            Files.delete(tempFile);
        } catch (final IOException exception) {
            throw new IllegalStateException("Filed to upload test file.", exception);
        }
    }

    @Override
    protected void uploadDataFile(final Path fileContent, final String fileName) {
        try (final FileInputStream fileInputStream = new FileInputStream(fileContent.toFile())) {
            testContainer.getBlobContainerClient().getBlobClient(fileName).upload(BinaryData.fromStream(fileInputStream));
        } catch (final IOException exception) {
            throw new IllegalStateException("Failed to read test-file", exception);
        }
    }

    @Override
    protected void createVirtualSchema(final String schemaName, final String mapping) {
        setup.createVirtualSchema(schemaName, mapping);
    }

    @Test
    void testInvalidConnection() throws BucketAccessException, TimeoutException {
        setup.getBucket().uploadInputStream(() -> getClass().getClassLoader().getResourceAsStream("simpleMapping.json"),
                "mapping.json");
        final ConnectionDefinition connection = setup.getExasolObjectFactory()
                .createConnectionDefinition("EMPTY_ABS_CONNECTION", "", "", "{");
        final VirtualSchema.Builder virtualSchemaBuilder = setup
                .getPreconfiguredVirtualSchemaBuilder("EMPTY_CONNECTION_SCHEMA").connectionDefinition(connection)
                .properties(Map.of("MAPPING", "/bfsdefault/default/mapping.json"));
        final DatabaseObjectException exception = assertThrows(DatabaseObjectException.class,
                virtualSchemaBuilder::build);
        assertThat(exception.getCause().getMessage(), containsString(
                "E-VSD-94: Invalid connection. The connection definition has a invalid syntax. Please check the user-guide at: https://github.com/exasol/azure-blob-storage-document-files-virtual-schema/blob/main/doc/user_guide/user_guide.md."));
    }
}
