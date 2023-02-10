package com.exasol.adapter.document.files.abstestsetup;

import java.net.InetSocketAddress;
import java.util.Optional;

import com.azure.storage.blob.BlobServiceClient;

public interface AbsTestSetup extends AutoCloseable {
    BlobServiceClient getAbsClient();

    @Override
    void close();

    boolean useSsl();

    Optional<InetSocketAddress> getInetSocketAddress();

    String getConnectionString(InetSocketAddress inetSocketAddress);

    default String getStorageAccountConnectionString() {
        return getConnectionString(getInetSocketAddress().orElse(null));
    }
}
