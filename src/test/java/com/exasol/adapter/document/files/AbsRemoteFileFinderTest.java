package com.exasol.adapter.document.files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.exasol.adapter.document.files.connection.AbsConnectionProperties;
import com.exasol.adapter.document.files.stringfilter.wildcardexpression.WildcardExpression;

class AbsRemoteFileFinderTest {
    @Test
    void testInvalidAbsCsException() {
        final var connectionInformation = AbsConnectionProperties.builder().containerName("my-bucket")
                .storageAccountConnectionString("{ invalid JSON").build();
        final WildcardExpression filter = WildcardExpression.fromGlob("*");
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new AbsRemoteFileFinder(filter, connectionInformation));
        assertThat(exception.getMessage(),
                containsString("Invalid connection string"));
    }
}