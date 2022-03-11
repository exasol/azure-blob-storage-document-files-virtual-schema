package com.exasol.adapter.document.files.abstestsetup;

import java.util.Optional;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.testcontainers.containers.GenericContainer;

public class LocalAbsTestSetup implements AbsTestSetup {
    private static final int PORT_IN_CONTAINER = 10000;
    private final GenericContainer<? extends GenericContainer<?>> azuriteContainer;
    private final String host;
    private BlobServiceClient blobServiceClient;
    private String connectionString;
    public LocalAbsTestSetup() {
        this.azuriteContainer = new GenericContainer<>("mcr.microsoft.com/azure-storage/azurite:3.16.0");
        this.azuriteContainer.addExposedPort(PORT_IN_CONTAINER);
        this.azuriteContainer.start();
        final Integer portOnHost = this.azuriteContainer.getMappedPort(PORT_IN_CONTAINER);
        this.host = "localhost:" + portOnHost;

        createAzuriteBlobServiceClient();
    }
    private void createAzuriteBlobServiceClient() {
        // Azurite default configuration
        var defaultEndpointsProtocol = "http";
        var accountName = "devstoreaccount1";
        var accountKey = "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==";
        var blobEndpoint =  "http://127.0.0.1:" + azuriteContainer.getMappedPort(PORT_IN_CONTAINER)+ "/devstoreaccount1";
        this.connectionString = "DefaultEndpointsProtocol="+defaultEndpointsProtocol+
                ";AccountName="+accountName+
                ";AccountKey="+ accountKey+
                ";BlobEndpoint="+ blobEndpoint+";";

        this.blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
    }

    @Override
    public BlobServiceClient getAbsClient() {
        return this.blobServiceClient;
    }

    @Override
    public String getStorageAccountConnectionString() {
        return this.connectionString;
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
