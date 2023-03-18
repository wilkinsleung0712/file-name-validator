package com.jpmorgan.validators.impl;

import com.jpmorgan.model.FileNameInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DateFormatValidatorTest {

    private final DateFormatValidator validator = new DateFormatValidator("ddmmyyyy");
    @Mock
    private FileNameInfo fni;

    @Test
    @DisplayName("Given valid date format as ddmmyyyy should not throw exception")
    void testDateformatWithddmmyyyy() {
        when(fni.getValuationDate()).thenReturn("07121987");
        Assertions.assertDoesNotThrow(() -> validator.validate(fni));
        verify(fni, times(1)).getValuationDate();
    }

    @Test
    @DisplayName("Given invalid date format should throw exception")
    void testInvalidDateformatWithddmmyyyy() {
        when(fni.getValuationDate()).thenReturn("32121987");
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validate(fni), "Valuation Date is not a valid date format ‘ddmmyyyy’.");
        verify(fni, times(1)).getValuationDate();
    }
}