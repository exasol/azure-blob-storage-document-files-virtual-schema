package com.exasol.adapter.document.files;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.models.BlobRange;
import com.azure.storage.blob.models.BlobRequestConditions;
import com.exasol.adapter.document.documentfetcher.files.randomaccessinputstream.RandomAccessInputStream;
import com.exasol.errorreporting.ExaError;

class AbsRandomAccessInputStream extends RandomAccessInputStream {
    private static final Logger LOGGER = Logger.getLogger(AbsRandomAccessInputStream.class.getName());
    //private final ReadChannel reader;
    private BlobClient blobClient;
    private final long fileSize;
    long position = 0;

    /**
     * Create a new instance of {@link AbsRandomAccessInputStream}.
     * 
     * @param blobClient blobClient
     * @param fileSize file size in bytes
     */
    AbsRandomAccessInputStream(final BlobClient blobClient, final long fileSize) {
        //this.reader = blob.reader();
        this.blobClient = blobClient;
        this.fileSize = fileSize;
    }

    @Override
    public void seek(final long position) {
        LOGGER.log(Level.INFO, "Seeked to position {}", position);
        this.position = position;
    }

    @Override
    public long getPos() {
        return this.position;
    }

    @Override
    public long getLength() {
        return this.fileSize;
    }

    @Override
    public int read() {
        //throw new UnsupportedOperationException();
        LOGGER.info("Performing single read at position.");
        if (this.position < getLength()) {
            final byte[] data; //= new byte[1];
            try {
                data = this.blobClient.openInputStream(new BlobRange(position,1L),null).readNBytes(1);
            } catch (final IOException exception) {
                throw getReadFailedException(exception);
            }
            this.position++;
            return data[0] ;//& 0xFF;
            //return data[0] & 0xFF;
        } else {
            return -1;
        }
    }

    @Override
    public int read(final byte[] targetBuffer, final int offset, final int length) {
        LOGGER.log(Level.INFO, "read - length: "+ length +" - offset: "+offset);

        if (length == 0) {
            return 0;
        }
        final long remainingBytesInFile = getLength() - this.position;
        final int actualReadLength = (int) Math.min(length, remainingBytesInFile);
        if (actualReadLength > 0) {
            try {

                this.blobClient.openInputStream(new BlobRange((long) position, (long) actualReadLength),new BlobRequestConditions()).read(targetBuffer);
            } catch (final IOException exception) {
                throw getReadFailedException(exception);
            }
            this.position += actualReadLength;
        }
        return actualReadLength == 0 ? -1 : actualReadLength;
    }

    private UncheckedIOException getReadFailedException(final IOException exception) {
        return new UncheckedIOException(
                ExaError.messageBuilder("E-VSABS-8").message("Failed to read from Azure Blob Storage.").toString(),
                exception);
    }
}
