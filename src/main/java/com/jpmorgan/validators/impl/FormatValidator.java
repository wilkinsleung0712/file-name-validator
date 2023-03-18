package com.jpmorgan.validators.impl;

import com.jpmorgan.validators.Validator;

public class FormatValidator implements Validator {

    private static final int FILENAME_REGEX_MATCHES_MIN = 3;
    private static final int FILENAME_VIA_SQ_REGEX_MATCHES_MAX = 4;
    private static final String VALUE_SPLIT = "_";
    private static final String FILE_NAME_FORMAT_ERROR = "File format should be ‘Test_<portfoliocode>_<ddmmyyyy>_<2digit-sequencenumber>.csv’";

    @Override
    public void validate(String fileName) {
        int matchesCount = fileName.split(VALUE_SPLIT).length;

        if(matchesCount < FILENAME_REGEX_MATCHES_MIN || matchesCount > FILENAME_VIA_SQ_REGEX_MATCHES_MAX) {
            throw new IllegalArgumentException(FILE_NAME_FORMAT_ERROR);
        }

    }
}
