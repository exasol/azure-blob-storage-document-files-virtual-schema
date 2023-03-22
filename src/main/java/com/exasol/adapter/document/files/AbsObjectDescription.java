package com.exasol.adapter.document.files;

/**
 * This class represents a reference to a ABS object.
 */
class AbsObjectDescription {
    private final String name;
    private final long size;

    AbsObjectDescription(final String name, final long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }
}
