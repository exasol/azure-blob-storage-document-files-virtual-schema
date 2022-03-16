package com.exasol.adapter.document.files.connection;

import lombok.Builder;
import lombok.Data;

/**
 * Connection properties for Azure Blob Storage.
 */
@Data
@Builder
public class AbsConnectionProperties {
    @Builder.Default
    private final String absStorageAccountConnectionString = null;
    @Builder.Default
    private final String absContainerName = null;

}
