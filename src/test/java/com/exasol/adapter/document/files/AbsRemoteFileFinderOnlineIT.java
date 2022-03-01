package com.exasol.adapter.document.files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

import com.exasol.adapter.document.files.connection.AbsConnectionProperties;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;
import com.exasol.adapter.document.files.abstestsetup.OnlineGcsTestSetup;
import com.exasol.adapter.document.files.stringfilter.wildcardexpression.WildcardExpression;

@Tag("integration")
class AbsRemoteFileFinderOnlineIT {
    private static final AbsTestSetup TEST_SETUP = new OnlineGcsTestSetup();
    private static final String CONTENT_1 = "content-1";
    private static AbsConnectionProperties connectionInformation;
    private static TestContainer testBucket;

    @BeforeAll
    static void beforeAll() {
        testBucket = new TestContainer(TEST_SETUP);
        testBucket.getBlobContainerClient().create("file-1.json", CONTENT_1.getBytes());
        connectionInformation = AbsConnectionProperties.builder().containerName(testBucket.getBlobContainerClient().getName())
                .gcKey(TEST_SETUP.getKeyFileAsJson()).gcHost(TEST_SETUP.getHostOverride().orElse(null))
                .useSsl(TEST_SETUP.useSsl()).build();
    }

    @AfterAll
    static void afterAll() {
        testBucket.close();
    }

    @Test
    void testReadFile() {
        final AbsRemoteFileFinder gcsFileLoader = new AbsRemoteFileFinder(
                WildcardExpression.forNonWildcardString("file-1.json"), connectionInformation);
        assertThat(runAndGetFirstLines(gcsFileLoader), containsInAnyOrder(CONTENT_1));
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