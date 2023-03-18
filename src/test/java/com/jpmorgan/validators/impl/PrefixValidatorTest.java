package com.jpmorgan.validators.impl;

import com.jpmorgan.model.FileNameInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrefixValidatorTest {
    @Mock
    private FileNameInfo fni;
    private final PrefixValidator validator = new PrefixValidator();

    @ParameterizedTest
    @ValueSource(strings = {"Test"})
    void testPortfolioCodeMatching(String prefix) {
        when(fni.getPrefix()).thenReturn(prefix);
        Assertions.assertDoesNotThrow(() -> validator.validate(fni));
        verify(fni, times(1)).getPrefix();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Te", "TeSt", "TEST", "Hello"})
    void testPortfolioThrowExceptionWhenFailMatching(String prefix) {
        when(fni.getPrefix()).thenReturn(prefix);
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(fni), String.format("Prefix for the file should be ‘Test’ found ‘%s’", prefix));
        verify(fni, times(1)).getPrefix();
    }
}