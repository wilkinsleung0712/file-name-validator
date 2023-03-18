package com.jpmorgan.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileNameInfoTest {

    @ParameterizedTest
    @MethodSource("provideArgsForFileNameInfoTest")
    void testFileNameInfoShouldBePopulateCorrectly(String fileName, String prefix, String portfolioCode, String valuationDate, String extension) {
        FileNameInfo fni = new FileNameInfo(fileName);
        assertEquals(prefix, fni.getPrefix());
        assertEquals(portfolioCode, fni.getPortfolioCode());
        assertEquals(valuationDate, fni.getValuationDate());
        assertEquals(extension, fni.getFileExtension());
        assertEquals(fileName, fni.getFileName());
    }

    @ParameterizedTest
    @MethodSource("provideArgsForInvalidFileNameInfoTest")
    void invalidFileNameShouldThrowException(String fileName, String errorMessage) {
        assertThrows(IllegalArgumentException.class, () -> new FileNameInfo(fileName), errorMessage);
    }

    private static Stream<Arguments> provideArgsForFileNameInfoTest() {
        return Stream.of(
                Arguments.of("Test_A_07121987.csv", "Test", "A", "07121987", "csv")
        );
    }

    private static Stream<Arguments> provideArgsForInvalidFileNameInfoTest() {
        return Stream.of(
                Arguments.of("Test_A_07121987.txt", "Invalid File format.Expected ‘csv’ found ‘txt’"),
                Arguments.of("Test.txt", "Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv")
        );
    }

}