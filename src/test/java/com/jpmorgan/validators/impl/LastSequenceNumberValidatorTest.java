package com.jpmorgan.validators.impl;

import com.jpmorgan.model.FileNameInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class LastSequenceNumberValidatorTest {

    private LastSequenceNumberValidator lastSequenceNumberValidator = new LastSequenceNumberValidator();
    @Mock private FileNameInfo fni;

    @Test
    @DisplayName("Sequence number validator should not throw exception when its empty")
    void testSequenceNumberIsEmptyString() {
        when(fni.getSequenceNumber()).thenReturn("");
        assertDoesNotThrow(() -> lastSequenceNumberValidator.validate(fni));
        verify(fni, times(1)).getSequenceNumber();
    }

    @ParameterizedTest
    @MethodSource("provideArgsForInvalidSequenceNumberTest")
    @DisplayName("Sequence number validator should throw exception when its not two digits")
    void testSequenceNumberIsInvalid(String sequenceNumber, String errorMessage) {
        when(fni.getSequenceNumber()).thenReturn(sequenceNumber);
        assertThrows(IllegalArgumentException.class, () -> lastSequenceNumberValidator.validate(fni), errorMessage);
        verify(fni, times(1)).getSequenceNumber();
    }

    private static Stream<Arguments> provideArgsForInvalidSequenceNumberTest() {
        return Stream.of(
                Arguments.of("111", "SequenceNumber for the file should be only 2 digits found ‘111’"),
                Arguments.of("1", "SequenceNumber for the file should be only 2 digits found ‘1’"),
                Arguments.of("-1", "SequenceNumber for the file should be only 2 digits found ‘-1’"),
                Arguments.of("ddd", "SequenceNumber for the file should be only 2 digits found ‘ddd’")
        );
    }

}