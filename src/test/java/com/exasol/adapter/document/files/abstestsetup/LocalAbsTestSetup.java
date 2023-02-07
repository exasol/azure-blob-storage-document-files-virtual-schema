package com.exasol.adapter.document.files.abstestsetup;

import java.net.InetSocketAddress;
import java.util.Optional;

import org.testcontainers.containers.GenericContainer;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class LocalAbsTestSetup implements AbsTestSetup {
    private static final int PORT_IN_CONTAINER = 10000;
    private final GenericContainer<? extends GenericContainer<?>> azuriteContainer;
    private BlobServiceClient blobServiceClient;
    private String connectionString;

    public LocalAbsTestSetup() {
        this.azuriteContainer = new GenericContainer<>("mcr.microsoft.com/azure-storage/azurite:3.21.0");
        this.azuriteContainer.addExposedPort(PORT_IN_CONTAINER);
        this.azuriteContainer.start();
        createAzuriteBlobServiceClient();
    }

    private void createAzuriteBlobServiceClient() {
        // Azurite default configuration
        final var defaultEndpointsProtocol = "http";
        final var accountName = "devstoreaccount1";
        final var accountKey = "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==";
        final var blobEndpoint = "http://" + this.azuriteContainer.getHost() + ":"
                + this.azuriteContainer.getMappedPort(PORT_IN_CONTAINER) + "/devstoreaccount1";
        this.connectionString = "DefaultEndpointsProtocol=" + defaultEndpointsProtocol + ";AccountName=" + accountName
                + ";AccountKey=" + accountKey + ";BlobEndpoint=" + blobEndpoint + ";";

        this.blobServiceClient = new BlobServiceClientBuilder().connectionString(this.connectionString).buildClient();
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
    public Optional<InetSocketAddress> getInetSocketAddress() {
        return Optional.of(new InetSocketAddress(this.azuriteContainer.getHost(),
                this.azuriteContainer.getMappedPort(PORT_IN_CONTAINER)));
    }

    @Override
    public String getConnectionString(final InetSocketAddress isa) {
        final String defaultEndpointsProtocol = "http";
        final String accountName = "devstoreaccount1";
        final String accountKey = "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==";
        final String blobEndpoint = "http://" //
                + isa.getHostString() //
                + ":" + isa.getPort() //
                + "/devstoreaccount1";
        return "DefaultEndpointsProtocol=" + defaultEndpointsProtocol + ";AccountName=" + accountName + ";AccountKey="
                + accountKey + ";BlobEndpoint=" + blobEndpoint + ";";
    }
}
