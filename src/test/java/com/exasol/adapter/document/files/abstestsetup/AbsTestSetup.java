package com.exasol.adapter.document.files.abstestsetup;

import java.util.Optional;

import com.azure.storage.blob.BlobServiceClient;

public interface AbsTestSetup extends AutoCloseable {
    BlobServiceClient getAbsClient();

    byte[] getKeyFileAsJson();

    @Override
    void close();

    boolean useSsl();

    Optional<String> getHostOverride();
}
