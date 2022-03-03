package com.exasol.adapter.document.files;

import lombok.Data;

/**
 * This class represents a reference to a ABS object.
 */
@Data
class AbsObjectDescription {
    private final String name;
    private final long size;
}
