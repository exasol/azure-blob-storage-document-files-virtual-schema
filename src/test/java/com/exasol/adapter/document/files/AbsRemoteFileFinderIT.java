package com.exasol.adapter.document.files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.azure.core.util.BinaryData;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.exasol.adapter.document.files.connection.AbsConnectionProperties;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;
import com.exasol.adapter.document.files.abstestsetup.LocalAbsTestSetup;
import com.exasol.adapter.document.files.stringfilter.wildcardexpression.WildcardExpression;

@Tag("integration")
class AbsRemoteFileFinderIT {
    private static final AbsTestSetup TEST_SETUP = new LocalAbsTestSetup();
    private static final String CONTENT_1 = "content-1";
    private static final String CONTENT_2 = "content-2";
    private static final String CONTENT_OTHER = "other";
    private static AbsConnectionProperties connectionInformation;
    private static TestContainer testContainer;

    @BeforeAll
    static void beforeAll() {
        testContainer = new TestContainer(TEST_SETUP);
        var blobContainerClient = testContainer.getBlobContainerClient();
        var file1= blobContainerClient.getBlobClient("file-1.json"); //CONTENT_1.getBytes());
        //var byteArrayInputStream = new ByteArrayInputStream(CONTENT_1.getBytes());
        file1.upload(BinaryData.fromBytes(CONTENT_1.getBytes()));
        var file2 = blobContainerClient.getBlobClient("file-2.json");//, CONTENT_2.getBytes());
        file2.upload(BinaryData.fromBytes(CONTENT_2.getBytes()));
        var file3 = blobContainerClient.getBlobClient("other.json"); //CONTENT_OTHER.getBytes());
        file3.upload(BinaryData.fromBytes(CONTENT_OTHER.getBytes()));
        connectionInformation = AbsConnectionProperties.builder().containerName(testContainer.getBlobContainerClient().getBlobContainerName())
                .storageAccountConnectionString(TEST_SETUP.getStorageAccountConnectionString()).build();
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

    @CsvSource({ //
            "file-*.json", //
            "file*.json", //
            "file-?.json" //
    })
    @ParameterizedTest
    void testReadFilesWithWildcard(final String fileGlob) {
        final WildcardExpression filePattern = WildcardExpression.fromGlob(fileGlob);
        final AbsRemoteFileFinder absFileLoader = new AbsRemoteFileFinder(filePattern, connectionInformation);
        assertThat(runAndGetFirstLines(absFileLoader), containsInAnyOrder(CONTENT_1, CONTENT_2));
    }

    @Test
    void testReadAllFiles() {
        final WildcardExpression filePattern = WildcardExpression.fromGlob("*");
        final AbsRemoteFileFinder absRemoteFileFinder = new AbsRemoteFileFinder(filePattern, connectionInformation);
        assertThat(runAndGetFirstLines(absRemoteFileFinder), containsInAnyOrder(CONTENT_1, CONTENT_2, CONTENT_OTHER));
    }

    private String readFirstLine(final InputStream stream) {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            return reader.readLine();
        } catch (final IOException exception) {
            throw new IllegalArgumentException("", exception);
        }
    }
}