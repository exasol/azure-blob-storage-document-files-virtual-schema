package com.exasol.adapter.document.files.connection;

import com.exasol.adapter.document.connection.ConnectionPropertiesReader;

public class AbsConnectionPropertiesReader {

    /**
     * Read the {@link AbsConnectionProperties} from file.
     * 
     * @param reader connection properties reader
     * @return read {@link AbsConnectionProperties}
     */
    public AbsConnectionProperties read(final ConnectionPropertiesReader reader) {
        return AbsConnectionProperties.builder()//
                .storageAcountConnectionString(reader.readRequiredString("storageAcountConnectionString"))
                .containerName(reader.readRequiredString("containerName"))
                .build();
    }
}
