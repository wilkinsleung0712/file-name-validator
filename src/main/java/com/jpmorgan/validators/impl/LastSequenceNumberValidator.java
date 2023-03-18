package com.jpmorgan.validators.impl;

import com.jpmorgan.model.FileNameInfo;
import com.jpmorgan.validators.FileNameValidator;

public class LastSequenceNumberValidator implements FileNameValidator {

    private static final String ERROR_MESSAGE = "SequenceNumber for the file should be only 2 digits found ‘%s’";
    @Override
    public void validate(FileNameInfo fileNameInfo) {
        String sequenceNumber = fileNameInfo.getSequenceNumber();
        if(sequenceNumber.length() == 0) {
            return;
        }

        if(sequenceNumber.length() != 2) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, sequenceNumber));
        }

        for(int i = 0; i < sequenceNumber.length(); i++) {
            if (sequenceNumber.charAt(i) < '0'
                    || sequenceNumber.charAt(i) > '9') {
                throw new IllegalArgumentException(String.format(ERROR_MESSAGE, sequenceNumber));
            }
        }
    }
}
