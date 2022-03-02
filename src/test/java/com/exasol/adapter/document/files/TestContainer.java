package com.exasol.adapter.document.files;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.models.BlobItem;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;

import lombok.Getter;

public class TestContainer implements AutoCloseable {
    @Getter
    private final BlobContainerClient blobContainerClient;

    public TestContainer(final AbsTestSetup testSetup) {
        final String containerName = "gcs-document-vs-test-" + System.currentTimeMillis();
        final BlobServiceClient absClient = testSetup.getAbsClient();
        this.blobContainerClient = absClient.createBlobContainer(containerName);
    }
    //https://github.com/Azure/azure-sdk-for-java/issues/10180
    public void empty() {
        for (final BlobItem file : this.blobContainerClient.listBlobs()) {
            var blobClient = blobContainerClient.getBlobClient(file.getName());
            blobClient.delete();
        }
    }

    @Override
    public void close() {
        empty();
        this.blobContainerClient.delete();
    }
}
