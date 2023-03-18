package com.jpmorgan;

import com.jpmorgan.model.FileNameInfo;
import com.jpmorgan.validators.FileNameValidator;

import java.util.HashSet;
import java.util.Set;

public class FileNameValidationProcessor {
    private final Set<String> fileNames;
    private final Set<String> validationResult;
    private final String FILE_VALIDATION_PASSED_OUTPUT = "File ‘%s’ passed validation.";
    private final String FILE_VALIDATION_FAILED_OUTPUT = "File ‘%s’ failed validation. %s";


    public FileNameValidationProcessor(Set<String> fileNames) {
        this.fileNames = fileNames;
        this.validationResult = new HashSet<>();
    }

    public Set<String> validate() {
        fileNames.forEach(fileName -> {
            boolean isError = false;
            try {
                FileNameInfo fn = new FileNameInfo(fileName);
                for (FileNameValidator validator : FileNameValidator.validator) {
                    validator.validate(fn);
                }
            } catch (IllegalArgumentException ex) {
                validationResult.add(String.format(FILE_VALIDATION_FAILED_OUTPUT, fileName, ex.getMessage()));
                isError = true;
            }

            if (!isError) {
                validationResult.add(String.format(FILE_VALIDATION_PASSED_OUTPUT, fileName));
            }

        });
        return validationResult;
    }
}
