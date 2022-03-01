package com.exasol.adapter.document.files;

import java.io.Closeable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** Lazy factory for an {@link ExecutorService}. */
public class ExecutorServiceFactory implements Closeable {
    private ExecutorService service = null;

    /**
     * Get an {@link ExecutorService}.
     * 
     * @return {@link ExecutorService}
     */
    public ExecutorService getExecutorService() {
        if (this.service == null) {
            this.service = Executors.newCachedThreadPool();
        }
        return this.service;
    }

    @Override
    public void close() {
        if (this.service != null) {
            this.service.shutdown();
        }
    }
}
