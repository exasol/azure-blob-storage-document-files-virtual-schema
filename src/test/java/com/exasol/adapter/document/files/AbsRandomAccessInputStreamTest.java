package com.exasol.adapter.document.files;

import com.azure.storage.blob.BlobClient;
import com.exasol.adapter.document.documentfetcher.files.randomaccessinputstream.RandomAccessInputStream;
import com.exasol.adapter.document.documentfetcher.files.randomaccessinputstream.RandomAccessInputStreamTestBase;
import com.exasol.adapter.document.files.abstestsetup.AbsTestSetup;
import com.exasol.adapter.document.files.abstestsetup.LocalAbsTestSetup;


class AbsRandomAccessInputStreamTest extends RandomAccessInputStreamTestBase {
    private static final String TEST_DATA_KEY = "TEST_DATA";
    long testDataLength;
    private AbsTestSetup testSetup;
    private TestContainer testBucket;
    private BlobClient blob;

    @Override
    protected void prepareTestSetup(final byte[] bytes) {
        this.testSetup = new LocalAbsTestSetup();
        this.testBucket = new TestContainer(this.testSetup);
        this.testDataLength = bytes.length;
        this.blob = this.testBucket.getBlobContainerClient().create(TEST_DATA_KEY, bytes);
    }

    @Override
    protected void cleanupTestSetup() {
        this.testBucket.close();
        this.testSetup.close();
    }

    @Override
    protected RandomAccessInputStream getSeekableInputStream() {
        return new AbsRandomAccessInputStream(this.blob, this.testDataLength);
    }
}