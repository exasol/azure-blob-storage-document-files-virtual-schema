package com.exasol.adapter.document.files.connection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.exasol.adapter.document.connection.ConnectionPropertiesReader;

class AbsConnectionPropertiesReaderTest {
    //test parsing the JSON settings
    @Test
    void testReadOnlyRequired() {
        final AbsConnectionProperties properties = runReader(
                "{\"storageAccountConnectionString\": \"my-connectionstring\", \"containerName\": \"my-containername\" }");
        assertAll(
                () -> assertThat(properties.getStorageAccountConnectionString(), equalTo("my-connectionstring")),
                () -> assertThat(properties.getContainerName(), equalTo("my-containername"))
        );

    }

    private AbsConnectionProperties runReader(final String json) {
        return new AbsConnectionPropertiesReader().read(new ConnectionPropertiesReader(json, ""));
    }

    @Test
    void testMissingRequired() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> runReader("{ }"));
        assertThat(exception.getMessage(), startsWith(
                "E-VSD-93: Invalid connection."));
    }
}