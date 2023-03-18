package com.jpmorgan.validators.impl;

import com.jpmorgan.validators.Validator;

public class FileExtensionValidator implements Validator {
    private static final String CSV_FILE_SUFFIX = "csv";
    private static final String ERROR_MESSAGE = "Invalid File format.Expected ‘csv’ found ‘%s’";
    @Override
    public void validate(String fileName) {
        assert fileName != null;
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if(!CSV_FILE_SUFFIX.equals(fileExtension)) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, fileExtension));
        }

    }
}
