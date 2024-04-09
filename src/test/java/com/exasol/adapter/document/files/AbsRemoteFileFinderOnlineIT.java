package com.exasol.adapter.document.files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import com.azure.core.util.BinaryData;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;
import com.exasol.adapter.document.files.abstestsetup.OnlineAbsTestSetup;
import com.exasol.adapter.document.files.connection.AbsConnectionProperties;
import com.exasol.adapter.document.files.stringfilter.wildcardexpression.WildcardExpression;

@Tag("integration")
class AbsRemoteFileFinderOnlineIT {
    private static final AbsTestSetup TEST_SETUP = new OnlineAbsTestSetup();
    private static final String CONTENT_1 = "content-1";
    private static AbsConnectionProperties connectionInformation;
    private static TestContainer testContainer;

    @BeforeAll
    static void beforeAll() {
        testContainer = TestContainer.create(TEST_SETUP);
        final var blobContainerClient = testContainer.getBlobContainerClient();
        final var file1 = blobContainerClient.getBlobClient("file-1.json");
        file1.upload(BinaryData.fromBytes(CONTENT_1.getBytes()));
        connectionInformation = AbsConnectionProperties.builder()
                .absContainerName(testContainer.getBlobContainerClient().getBlobContainerName())
                .absStorageAccountConnectionString(TEST_SETUP.getStorageAccountConnectionString()).build();
    }

    @AfterAll
    static void afterAll() {
        testContainer.close();
    }

    @Test
    void testReadFile() {
        final AbsRemoteFileFinder absFileLoader = new AbsRemoteFileFinder(
                WildcardExpression.forNonWildcardString("file-1.json"), connectionInformation);
        assertThat(runAndGetFirstLines(absFileLoader), containsInAnyOrder(CONTENT_1));
    }

    private List<String> runAndGetFirstLines(final AbsRemoteFileFinder absFileLoader) {
        final List<String> result = new ArrayList<>();
        absFileLoader.loadFiles()
                .forEachRemaining(file -> result.add(readFirstLine(file.getContent().getInputStream())));
        return result;
    }

    private String readFirstLine(final InputStream stream) {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            return reader.readLine();
        } catch (final IOException exception) {
            throw new IllegalArgumentException("", exception);
        }
    }
}
