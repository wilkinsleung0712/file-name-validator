package com.jpmorgan;

import com.jpmorgan.utils.FileUtils;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> fileNames = Set.of();
        boolean validLocationPath = false;

        do {
            try {
                System.out.print("Enter absolute directory path : ");
                String fileLocation = scan.next();
                fileNames = FileUtils.listFilesFromDirectory(fileLocation);
                validLocationPath = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (!validLocationPath);

        FileNameValidationProcessor fvp = new FileNameValidationProcessor(fileNames);
        Set<String> result = fvp.validate();
        result.forEach(System.out::println);
    }
}