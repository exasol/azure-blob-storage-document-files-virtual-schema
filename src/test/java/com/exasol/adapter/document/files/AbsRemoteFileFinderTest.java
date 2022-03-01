package com.exasol.adapter.document.files;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.exasol.adapter.document.files.connection.AbsConnectionProperties;
import com.exasol.adapter.document.files.stringfilter.wildcardexpression.WildcardExpression;

class AbsRemoteFileFinderTest {
//    @Test
//    void testInvalidGcKeyException() {
//        final var connectionInformation = AbsConnectionProperties.builder().gcsBucket("my-bucket")
//                .gcKey("{ invalid JSON".getBytes()).build();
//        final WildcardExpression filter = WildcardExpression.fromGlob("*");
//        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
//                () -> new AbsRemoteFileFinder(filter, connectionInformation));
//        assertThat(exception.getMessage(),
//                equalTo("E-VSABS-9: Failed to read Google key definition. Please check the value of gcKey."));
//    }
}