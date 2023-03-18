package com.jpmorgan.validators;

import com.jpmorgan.model.FileNameInfo;
import com.jpmorgan.validators.impl.DateFormatValidator;
import com.jpmorgan.validators.impl.LastSequenceNumberValidator;
import com.jpmorgan.validators.impl.PortfolioCodeValidator;
import com.jpmorgan.validators.impl.PrefixValidator;

import java.util.List;

public interface FileNameValidator {
    List<FileNameValidator> validator = List.of(
            new PrefixValidator(),
            new PortfolioCodeValidator(),
            new DateFormatValidator("ddmmyyyy"),
            new LastSequenceNumberValidator()
    );

    void validate(FileNameInfo fileNameInfo);
}
