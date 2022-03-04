package com.exasol.adapter.document.files;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import com.exasol.adapter.document.documentfetcher.files.RemoteFile;
import com.exasol.adapter.document.documentfetcher.files.RemoteFileFinder;
import com.exasol.adapter.document.files.connection.AbsConnectionProperties;
import com.exasol.adapter.document.files.stringfilter.StringFilter;
import com.exasol.adapter.document.iterators.*;


/**
 * File finder for files on Azure Blob Storage.
 */
public class AbsRemoteFileFinder implements RemoteFileFinder {
    private final StringFilter filePattern;
    private final BlobContainerClient blobContainerClient;
    //START HERE
    /**
     * Create a new instance of {@link AbsRemoteFileFinder}.
     *
     * @param filePattern          pattern to search for
     * @param connectionProperties connection information
     */

    //the c'tor sets up a Blob Storage Container client and saves the file pattern for internal operations.
    public AbsRemoteFileFinder(final StringFilter filePattern, final AbsConnectionProperties connectionProperties) {
        //"storage" in GCP
        final BlobServiceClient storageAccountBlobServiceClient = buildAbsClient(connectionProperties);
        //container is the equivalent to the GCP bucket
        BlobContainerClient blobContainerClient = storageAccountBlobServiceClient.getBlobContainerClient(connectionProperties.getContainerName());
        //"bucket" in GCP
        this.blobContainerClient = blobContainerClient;
        this.filePattern = filePattern;
    }
    private BlobServiceClient buildAbsClient(final AbsConnectionProperties connectionProperties) {
        // Create a BlobServiceClient object which will be used to create a container client
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectionProperties.getStorageAccountConnectionString()).buildClient();

        return blobServiceClient;
    }

    @SuppressWarnings("java:S2095") // executorServiceFactory is closed by CloseInjectIterator
    @Override
    public CloseableIterator<RemoteFile> loadFiles() {
        //get the files info
        final CloseableIterator<AbsObjectDescription> objectKeys = getQuickFilteredObjectKeys();
        //filter files again
        final com.exasol.adapter.document.files.stringfilter.matcher.Matcher filePatternMatcher = this.filePattern
                .getDirectoryIgnoringMatcher();
        final FilteringIterator<AbsObjectDescription> filteredObjectKeys = new FilteringIterator<>(objectKeys,
                s3Object -> filePatternMatcher.matches(s3Object.getName()));
        //load all the files
        final ExecutorServiceFactory executorServiceFactory = new ExecutorServiceFactory();
        final CloseableIterator<RemoteFile> loadedFiles = new TransformingIterator<>(filteredObjectKeys,
                description -> this.loadFile(description, executorServiceFactory));
        return new CloseInjectIterator<>(loadedFiles, executorServiceFactory::close);
    }

    /**
     * Get a list of object keys.
     *
     * <p>
     * This method only applies the filters that can be applied on ABS. So you have to filter the output once again with
     * a more featured matcher.
     * </p>
     *
     * @return partially filtered list of object keys
     */
    private CloseableIterator<AbsObjectDescription> getQuickFilteredObjectKeys() {

        final String globFreeKey = this.filePattern.getStaticPrefix();
        //todo: look at early filtering here again, the globFreeKey thing, if possible within the call,
        // change function description above accordingly
        final CloseableIterator<BlobItem> files = new CloseableIteratorWrapper<>(
                this.blobContainerClient.listBlobs().iterator()
        );
        return new TransformingIterator<>(files, file -> new AbsObjectDescription(file.getName(), file.getProperties().getContentLength()));
    }

    private RemoteFile loadFile(final AbsObjectDescription fileDescription,
            final ExecutorServiceFactory executorServiceFactory) {
        return new RemoteFile(fileDescription.getName(), fileDescription.getSize(),
                new AbsRemoteFileContent(this.blobContainerClient, fileDescription, executorServiceFactory));
    }
}
