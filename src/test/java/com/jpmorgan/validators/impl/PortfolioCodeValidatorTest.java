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
class PortfolioCodeValidatorTest {

    @Mock private FileNameInfo fni;
    private final PortfolioCodeValidator validator = new PortfolioCodeValidator();

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C"})
    void testPortfolioCodeMatching(String portfolioCode) {
        when(fni.getPortfolioCode()).thenReturn(portfolioCode);
        Assertions.assertDoesNotThrow(() -> validator.validate(fni));
        verify(fni, times(1)).getPortfolioCode();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "E", "e", ""})
    void testPortfolioThrowExceptionWhenFailMatching(String portfolioCode) {
        when(fni.getPortfolioCode()).thenReturn(portfolioCode);
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(fni), String.format("PortfolioCode should be A/B/C found %s", portfolioCode));
        verify(fni, times(1)).getPortfolioCode();
    }
}