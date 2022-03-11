package com.exasol.adapter.document.files.abstestsetup;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

public class OnlineAbsTestSetup implements AbsTestSetup {
    private static final String KEY_FILE = "abs-cs.json";
    private final String connectionString;
    private final BlobServiceClient blobServiceClient;

    public OnlineAbsTestSetup() {
        if (!Files.exists(Path.of(KEY_FILE))) {
            throw new IllegalStateException("Could not find " + KEY_FILE
                    + ". Please create a azure blob storage account, get the connection string and store it in this project as "
                    + KEY_FILE + ".");
        }
        try {
            this.connectionString = Files.readString(Path.of(KEY_FILE));
            this.blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionString).buildClient();
        } catch (final IOException exception) {
            throw new UncheckedIOException("Failed to read abs credentials from file.", exception);
        }
    }

    @Override
    public BlobServiceClient getAbsClient() {
        return this.blobServiceClient;
    }

    @Override
    public String getStorageAccountConnectionString() {
        return connectionString;
    }

    @Override
    public void close() {
        // nothing to do
    }

    @Override
    public boolean useSsl() {
        return true;
    }

    @Override
    public Optional<String> getHostOverride() {
        return Optional.empty();
    }
}
