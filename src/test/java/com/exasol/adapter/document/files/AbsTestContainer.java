package com.exasol.adapter.document.files;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobItem;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;

public class AbsTestContainer implements AutoCloseable {
    private final BlobContainerClient blobContainerClient;
    private final String blobContainerName;

    private AbsTestContainer(final BlobContainerClient containerClient, final String containerName) {
        this.blobContainerClient = containerClient;
        this.blobContainerName = containerName;
    }

    public static AbsTestContainer create(final AbsTestSetup testSetup) {
        final String containerName = "abs-document-vs-test-" + System.currentTimeMillis();
        final BlobServiceClient absClient = testSetup.getAbsClient();
        final BlobContainerClient containerClient = absClient.createBlobContainer(containerName);
        return new AbsTestContainer(containerClient, containerName);
    }

    // https://github.com/Azure/azure-sdk-for-java/issues/10180
    public void empty() {
        for (final BlobItem file : this.blobContainerClient.listBlobs()) {
            final var blobClient = blobContainerClient.getBlobClient(file.getName());
            blobClient.delete();
        }
    }

    public BlobContainerClient getBlobContainerClient() {
        return blobContainerClient;
    }

    public String getBlobContainerName() {
        return blobContainerName;
    }

    @Override
    public void close() {
        empty();
        this.blobContainerClient.delete();
    }
}
