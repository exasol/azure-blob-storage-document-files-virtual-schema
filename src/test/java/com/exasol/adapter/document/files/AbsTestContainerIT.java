package com.exasol.adapter.document.files;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobItem;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;
import com.exasol.adapter.document.files.abstestsetup.OnlineAbsTestSetup;

@Tag("integration")
class AbsTestContainerIT {

    static AbsTestSetup absTestSetup = new OnlineAbsTestSetup();

    @Test
    void emptyFilledContainer() {
        try (final AbsTestContainer testContainer = AbsTestContainer.create(absTestSetup)) {
            final BlobContainerClient client = testContainer.getBlobContainerClient();
            client.getBlobClient("blobName").upload(BinaryData.fromString("blob content"));
            assertThat(listBlobNames(client), contains("blobName"));
            testContainer.empty();
            assertThat(listBlobNames(client), empty());
        }
    }

    // Note: This test is expected to fail when Azure Blob Storage Gen2 is enabled.
    @Test
    void emptyFilledContainerWithDirectory() {
        try (final AbsTestContainer testContainer = AbsTestContainer.create(absTestSetup)) {
            final BlobContainerClient client = testContainer.getBlobContainerClient();
            client.getBlobClient("dir/blobName").upload(BinaryData.fromString("blob content"));
            assertThat(listBlobNames(client), contains("dir/blobName"));
            testContainer.empty();
            assertThat(listBlobNames(client), empty());
        }
    }

    @Test
    void checkBlobStorageVersion() {
        try (final AbsTestContainer testContainer = AbsTestContainer.create(absTestSetup)) {
            final BlobContainerClient client = testContainer.getBlobContainerClient();
            client.getBlobClient("dir/blobName").upload(BinaryData.fromString("blob content"));
            final List<String> blobNames = listBlobNames(client);
            if (blobNames.size() > 1) {
                fail("Expected exactly one blob, but found " + blobNames.size() + " blobs.: " + blobNames
                        + ". This usually means that Azure Blob Storage Gen2 is enabled. Please create a new storage account without Gen2 enabled.");
            }
            assertThat(listBlobNames(client), contains("dir/blobName"));
        }
    }

    private List<String> listBlobNames(final BlobContainerClient client) {
        return client.listBlobs().stream().map(BlobItem::getName).collect(toList());
    }
}
