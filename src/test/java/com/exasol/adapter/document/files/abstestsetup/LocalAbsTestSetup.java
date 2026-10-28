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
    private final BlobServiceClient blobServiceClient;

    public LocalAbsTestSetup() {
        // https://mcr.microsoft.com/en-us/product/azure-storage/azurite/tags
        this.azuriteContainer = new GenericContainer<>("mcr.microsoft.com/azure-storage/azurite:3.36.0");
        this.azuriteContainer.addExposedPort(PORT_IN_CONTAINER);
        this.azuriteContainer.setCommand("azurite",
                "-l", "/data",
                "--blobHost", "0.0.0.0",
                "--queueHost", "0.0.0.0",
                "--tableHost", "0.0.0.0",
                // No newer docker image available, need to disable API version check
                "--skipApiVersionCheck");
        this.azuriteContainer.start();
        this.blobServiceClient = createAzuriteBlobServiceClient(this.azuriteContainer.getHost(),
                this.azuriteContainer.getMappedPort(PORT_IN_CONTAINER));
    }

    private static BlobServiceClient createAzuriteBlobServiceClient(final String host, final int port) {
        return new BlobServiceClientBuilder() //
                .connectionString(createConnectionString(host, port)) //
                .buildClient();
    }

    private static String createConnectionString(final String host, final int port) {
        return "DefaultEndpointsProtocol=http" //
                + ";AccountName=" + ACCOUNT_NAME //
                + ";AccountKey=" + ACCOUNT_KEY //
                + ";BlobEndpoint=http://" + host + ":" + port + "/" + ACCOUNT_NAME + ";";
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
        return createConnectionString(inetSocketAddress.getHostString(), inetSocketAddress.getPort());
    }

}
