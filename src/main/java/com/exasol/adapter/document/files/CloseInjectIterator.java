package com.exasol.adapter.document.files;

import com.exasol.adapter.document.iterators.CloseableIterator;

import lombok.RequiredArgsConstructor;

/**
 * {@link CloseableIterator} that injects an additional close function.
 * 
 * @param <T> iterator type
 */
@RequiredArgsConstructor
class CloseInjectIterator<T> implements CloseableIterator<T> {
    private final CloseableIterator<T> source;
    private final Runnable onClose;

    @Override
    public void close() {
        this.onClose.run();
        this.source.close();
    }

    @Override
    public boolean hasNext() {
        return this.source.hasNext();
    }

    @Override
    public T next() {
        return this.source.next();
    }
}
