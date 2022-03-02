package com.exasol.adapter.document.files.abstestsetup;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

//https://tech-blog.lectra.com/article/781-azurite-testcontainers-comment-tester-azure-blob-storage-sans-nuage
//@Testcontainers
//class AzuriteContainer extends GenericContainer<AzuriteContainer> ("mcr.microsoft.com/azure-storage/azurite") {
//    inherits ;
//}

public class LocalAbsTestSetup implements AbsTestSetup {
    private static final int PORT_IN_CONTAINER = 10000;
    private final GenericContainer<? extends GenericContainer<?>> azuriteContainer;
    private final String host;
    //TODO: see if something like this exists for abs -> azurite
    public LocalAbsTestSetup() {
        this.azuriteContainer = new GenericContainer<>("mcr.microsoft.com/azure-storage/azurite");
        this.azuriteContainer.addExposedPort(PORT_IN_CONTAINER);
        this.azuriteContainer.start();

        final Integer portOnHost = this.azuriteContainer.getMappedPort(PORT_IN_CONTAINER);
        this.host = "localhost:" + portOnHost;
    }

    @Override
    public BlobServiceClient getAbsClient() {
//        return StorageOptions.newBuilder().setHost("http://" + this.host).setProjectId("test-project")
//                .setCredentials(NoCredentials.getInstance()).build().getService();

        //todo add connectionProperties
        // Azurite default configuration
        var defaultEndpointsProtocol = "http";
        var accountName = "devstoreaccount1";
        var accountKey = "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==";
        var blobEndpoint = "http://127.0.0.1:${azuriteContainer.getMappedPort(10000)}/devstoreaccount1";
        var connectionString = String.format( "DefaultEndpointsProtocol=$defaultEndpointsProtocol;AccountName=$accountName;AccountKey=$accountKey;BlobEndpoint=$blobEndpoint;",
                defaultEndpointsProtocol,accountName,accountKey,blobEndpoint);

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();

        return blobServiceClient;
    }

    @Override
    public byte[] getKeyFileAsJson() {
        final String json = "null";
        return json.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void close() {
        this.azuriteContainer.stop();
    }

    @Override
    public boolean useSsl() {
        return false;
    }

    @Override
    public Optional<String> getHostOverride() {
        return Optional.of(this.host);
    }
}
