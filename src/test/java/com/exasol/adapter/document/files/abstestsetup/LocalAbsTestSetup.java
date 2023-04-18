package com.exasol.adapter.document.files.abstestsetup;

import java.net.InetSocketAddress;
import java.util.Optional;

import org.testcontainers.containers.GenericContainer;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class LocalAbsTestSetup implements AbsTestSetup {

    private static final String ACCOUNT_NAME = "devstoreaccount1";
    private static final String ACCOUNT_KEY = "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq" //
            + "/K1SZFPTOtr" //
            + "/KBHBeksoGMGw==";
    private static final int PORT_IN_CONTAINER = 10000;

    private final GenericContainer<? extends GenericContainer<?>> azuriteContainer;
    private BlobServiceClient blobServiceClient;

    public LocalAbsTestSetup() {
        this.azuriteContainer = new GenericContainer<>("mcr.microsoft.com/azure-storage/azurite:3.23.0");
        this.azuriteContainer.addExposedPort(PORT_IN_CONTAINER);
        this.azuriteContainer.start();
        createAzuriteBlobServiceClient();
    }

    private void createAzuriteBlobServiceClient() {
        this.blobServiceClient = new BlobServiceClientBuilder() //
                .connectionString(getStorageAccountConnectionString()) //
                .buildClient();
    }

    @Override
    public BlobServiceClient getAbsClient() {
        return this.blobServiceClient;
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
    public String getConnectionString(final InetSocketAddress inetSocketAddress) {
        final String defaultEndpointsProtocol = "http";
        final String blobEndpoint = "http://" //
                + inetSocketAddress.getHostString() //
                + ":" + inetSocketAddress.getPort() //
                + "/" + ACCOUNT_NAME;
        return "DefaultEndpointsProtocol=" + defaultEndpointsProtocol //
                + ";AccountName=" + ACCOUNT_NAME //
                + ";AccountKey=" + ACCOUNT_KEY //
                + ";BlobEndpoint=" + blobEndpoint + ";";
    }

}
