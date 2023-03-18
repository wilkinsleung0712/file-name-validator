package com.jpmorgan.validators.impl;

import com.jpmorgan.model.FileNameInfo;
import com.jpmorgan.validators.FileNameValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatValidator implements FileNameValidator {

    private String dateFormat;
    private static final String DATE_VALIDATION_ERROR_MESSAGE = "Valuation Date is not a valid date format ‘ddmmyyyy’.";

    public DateFormatValidator(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public void validate(FileNameInfo fileNameInfo) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(fileNameInfo.getValuationDate());
        } catch (ParseException e) {
            throw new IllegalArgumentException(DATE_VALIDATION_ERROR_MESSAGE);
        }
    }
}
