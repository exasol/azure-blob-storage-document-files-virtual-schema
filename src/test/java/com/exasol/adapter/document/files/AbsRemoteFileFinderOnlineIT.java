package com.exasol.adapter.document.files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.azure.core.util.BinaryData;
import org.junit.jupiter.api.*;

import com.exasol.adapter.document.files.connection.AbsConnectionProperties;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;
import com.exasol.adapter.document.files.abstestsetup.OnlineAbsTestSetup;
import com.exasol.adapter.document.files.stringfilter.wildcardexpression.WildcardExpression;

@Tag("integration")
class AbsRemoteFileFinderOnlineIT {
    private static final AbsTestSetup TEST_SETUP = new OnlineAbsTestSetup();
    private static final String CONTENT_1 = "content-1";
    private static AbsConnectionProperties connectionInformation;
    private static TestContainer testContainer;

    @BeforeAll
    static void beforeAll() {
        testContainer = new TestContainer(TEST_SETUP);
        var blobContainerClient = testContainer.getBlobContainerClient();
        var file1= blobContainerClient.getBlobClient("file-1.json");
        file1.upload(BinaryData.fromBytes(CONTENT_1.getBytes()));
        connectionInformation = AbsConnectionProperties.builder().containerName(testContainer.getBlobContainerClient().getBlobContainerName())
                .gcKey(TEST_SETUP.getKeyFileAsJson()).gcHost(TEST_SETUP.getHostOverride().orElse(null))
                .useSsl(TEST_SETUP.useSsl()).build();
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

    private List<String> runAndGetFirstLines(final AbsRemoteFileFinder gcsFileLoader) {
        final List<String> result = new ArrayList<>();
        gcsFileLoader.loadFiles()
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