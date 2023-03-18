package com.jpmorgan.model;

import com.jpmorgan.validators.impl.FileExtensionValidator;
import com.jpmorgan.validators.impl.FormatValidator;

public class FileNameInfo {
    private final String prefix;
    private final String portfolioCode;
    private final String valuationDate;
    private final String sequenceNumber;
    private final String fileExtension;
    private final String fileName;

    public FileNameInfo(String fileName) {
        FormatValidator formatValidator = new FormatValidator();
        FileExtensionValidator fileExtensionValidator = new FileExtensionValidator();
        formatValidator.validate(fileName);
        fileExtensionValidator.validate(fileName);

        this.fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        String fileNamePattern = fileName.substring(0, fileName.lastIndexOf("."));
        String[] matches = fileNamePattern.split("_");
        this.prefix = matches[0];
        this.portfolioCode = matches[1];
        this.valuationDate = matches[2];
        this.sequenceNumber = matches.length == 4 ? matches[3] : "";
        this.fileName = fileName;

    }

    public String getPrefix() {
        return prefix;
    }

    public String getPortfolioCode() {
        return portfolioCode;
    }

    public String getValuationDate() {
        return valuationDate;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileName() {
        return fileName;
    }
}
