package com.jpmorgan.validators.impl;

import com.jpmorgan.model.FileNameInfo;
import com.jpmorgan.validators.FileNameValidator;

public class PrefixValidator implements FileNameValidator {

    private static final String FILE_SUFFIX = "Test";
    private static final String FILE_SUFFIX_VALIDATION_ERROR = "Prefix for the file should be ‘Test’ found ‘%s’";

    @Override
    public void validate(FileNameInfo fileNameInfo) {
        String prefix = fileNameInfo.getPrefix();
        if(!FILE_SUFFIX.equals(prefix)) {
            throw new IllegalArgumentException(String.format(FILE_SUFFIX_VALIDATION_ERROR, prefix));
        }
    }
}
