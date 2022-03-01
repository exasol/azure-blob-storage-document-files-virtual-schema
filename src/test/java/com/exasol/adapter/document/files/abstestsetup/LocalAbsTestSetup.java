package com.exasol.adapter.document.files.abstestsetup;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import com.azure.storage.blob.BlobServiceClient;
import org.testcontainers.containers.GenericContainer;

import com.google.cloud.NoCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

public class LocalAbsTestSetup implements AbsTestSetup {
    private static final int PORT_IN_CONTAINER = 4443;
    private final GenericContainer<? extends GenericContainer<?>> container;
    private final String host;
    //TODO: see if something like this exists for abs
    public LocalAbsTestSetup() {
        this.container = new GenericContainer<>("fsouza/fake-gcs-server:1.34");
        this.container.addExposedPort(PORT_IN_CONTAINER);
        this.container
                .withCreateContainerCmdModifier(cmd -> cmd.withEntrypoint("/bin/fake-gcs-server", "-scheme", "http"));
        this.container.start();
        final Integer portOnHost = this.container.getMappedPort(PORT_IN_CONTAINER);
        this.host = "localhost:" + portOnHost;
    }

    @Override
    public BlobServiceClient getAbsClient() {
        return StorageOptions.newBuilder().setHost("http://" + this.host).setProjectId("test-project")
                .setCredentials(NoCredentials.getInstance()).build().getService();
    }

    @Override
    public byte[] getKeyFileAsJson() {
        final String json = "null";
        return json.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public void close() {
        this.container.stop();
    }

    @Override
    public boolean useSsl() {
        return false;
    }

    @Override
    public Optional<String> getHostOverride() {
        return Optional.of(this.host);
    }
}
