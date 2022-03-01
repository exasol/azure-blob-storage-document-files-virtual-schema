package com.exasol.adapter.document.files;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;

import lombok.Getter;

public class TestContainer implements AutoCloseable {
    @Getter
    private final BlobContainerClient blobContainerClient;

    public TestContainer(final AbsTestSetup testSetup) {
        final String bucketName = "gcs-document-vs-test-" + System.currentTimeMillis();
        final BlobServiceClient absClient = testSetup.getAbsClient();
        this.blobContainerClient = absClient.create(BucketInfo.newBuilder(bucketName).build());
    }

    public void empty() {
        for (final Blob file : this.blobContainerClient.list().iterateAll()) {
            file.delete();
        }
    }

    @Override
    public void close() {
        empty();
        this.blobContainerClient.delete();
    }
}
