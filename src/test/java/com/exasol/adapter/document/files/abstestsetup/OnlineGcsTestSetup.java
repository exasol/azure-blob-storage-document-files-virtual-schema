package com.exasol.adapter.document.files.abstestsetup;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class OnlineGcsTestSetup implements AbsTestSetup {
    private static final String KEY_FILE = "google-key.json";
    private final BlobServiceClient storageClient;

    public OnlineGcsTestSetup() {
        if (!Files.exists(Path.of(KEY_FILE))) {
            throw new IllegalStateException("Could not find " + KEY_FILE
                    + ". Please create a google-cloud service account, create a key and store it in this project as "
                    + KEY_FILE + ".");
        }
        try {
            final GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(KEY_FILE));
            this.storageClient = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        } catch (final IOException exception) {
            throw new UncheckedIOException("Failed to read gcs credentials from file.", exception);
        }
    }

    @Override
    public Storage getAbsClient() {
        return this.storageClient;
    }

    @Override
    public byte[] getKeyFileAsJson() {
        try {
            return Files.readAllBytes(Path.of(KEY_FILE));
        } catch (final IOException exception) {
            throw new UncheckedIOException("Faile to read credential file", exception);
        }
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
