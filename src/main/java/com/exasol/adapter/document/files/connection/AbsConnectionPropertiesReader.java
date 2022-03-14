package com.exasol.adapter.document.files.connection;

import com.exasol.adapter.document.connection.ConnectionPropertiesReader;

/**
 * Reads out the Azure Blob Storage connection properties.
 */
public class AbsConnectionPropertiesReader {

    /**
     * Read the {@link AbsConnectionProperties} from file.
     * 
     * @param reader connection properties reader
     * @return read {@link AbsConnectionProperties}
     */
    public AbsConnectionProperties read(final ConnectionPropertiesReader reader) {
        return AbsConnectionProperties.builder()//
                .absStorageAccountConnectionString(reader.readRequiredString("absStorageAccountConnectionString"))
                .absContainerName(reader.readRequiredString("absContainerName"))
                .build();
    }
}
