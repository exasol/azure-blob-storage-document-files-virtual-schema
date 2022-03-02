package com.exasol.adapter.document.files;

import java.io.InputStream;
import java.util.concurrent.Future;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.exasol.adapter.document.documentfetcher.files.RemoteFileContent;
import com.exasol.adapter.document.documentfetcher.files.randomaccessinputstream.RandomAccessInputStream;
import com.exasol.adapter.document.documentfetcher.files.randomaccessinputstream.RandomAccessInputStreamCache;


/**
 * {@link RemoteFileContent} for Azure Blob Storage.
 */
class AbsRemoteFileContent implements RemoteFileContent {
    private static final int SIZE_1_MB = 1000000;
    private final BlobContainerClient blobContainerClient;
    private final AbsObjectDescription fileToRead;
    private final ExecutorServiceFactory executorServiceFactory;

    /**
     * Create a new instance of {@link AbsRemoteFileContent}.
     * 
     * @param blobContainerClient     ABS blobContainerClient
     * @param fileToRead file to read
     */
    public AbsRemoteFileContent(final BlobContainerClient blobContainerClient, final AbsObjectDescription fileToRead,
                                final ExecutorServiceFactory executorServiceFactory) {
        this.blobContainerClient = blobContainerClient;
        this.fileToRead = fileToRead;
        this.executorServiceFactory = executorServiceFactory;
    }

    @Override
    public InputStream getInputStream() {
        return getFile().openInputStream();
    }
    private BlobClient getFile() {

        BlobClient blobClient = this.blobContainerClient.getBlobClient(this.fileToRead.getName());
        return blobClient;
    }

    @Override
    public RandomAccessInputStream getRandomAccessInputStream() {
        return new RandomAccessInputStreamCache(new AbsRandomAccessInputStream(getFile(), this.fileToRead.getSize()),
                SIZE_1_MB);
    }
    //todo: look if this can be done in an async way
    @Override
    public Future<byte[]> loadAsync() {
        return this.executorServiceFactory.getExecutorService().submit(() -> getFile().downloadContent().toBytes());
    }
}
