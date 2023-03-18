package com.jpmorgan.validators.impl;

import com.jpmorgan.model.FileNameInfo;
import com.jpmorgan.validators.FileNameValidator;

import java.util.Set;

public class PortfolioCodeValidator implements FileNameValidator {

    private static final Set<String> PORTFOLIO_CODE  =Set.of("A","B","C");
    private static final String ERROR_MESSAGE = "PortfolioCode should be A/B/C found %s";
    @Override
    public void validate(FileNameInfo fileNameInfo) {
        String portfolioCode = fileNameInfo.getPortfolioCode();
        if(!PORTFOLIO_CODE.contains(portfolioCode)) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, portfolioCode));
        }
    }
}
