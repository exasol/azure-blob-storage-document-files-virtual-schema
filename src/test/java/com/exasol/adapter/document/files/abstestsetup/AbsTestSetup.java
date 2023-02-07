package com.exasol.adapter.document.files.abstestsetup;

import java.net.InetSocketAddress;
import java.util.Optional;

import com.azure.storage.blob.BlobServiceClient;

public interface AbsTestSetup extends AutoCloseable {
    BlobServiceClient getAbsClient();

    String getStorageAccountConnectionString();

    @Override
    void close();

    boolean useSsl();

    Optional<InetSocketAddress> getInetSocketAddress();

    String getConnectionString(InetSocketAddress inetSocketAddress);
}
