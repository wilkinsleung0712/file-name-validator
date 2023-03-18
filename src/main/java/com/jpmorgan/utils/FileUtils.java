package com.jpmorgan.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {
    public static Set<String> listFilesFromDirectory(String dir) {
        try (Stream<Path> stream = Files.list(Paths.get(dir))) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.toSet());
        } catch (InvalidPathException invalidPathException) {
            throw new IllegalArgumentException(String.format("Provided path [%s] is not valid", dir));
        } catch (
                NotDirectoryException nde) {
            throw new IllegalArgumentException(String.format("Provided path [%s] is not a directory", dir));
        } catch (
                SecurityException se) {
            throw new IllegalArgumentException(String.format("Provided path [%s] does not has enough permission", dir));
        } catch (NoSuchFileException nsfe) {
            throw new IllegalArgumentException(String.format("Provided path [%s] does not exist", dir));
        } catch (IOException ioe) {
            throw new IllegalArgumentException(String.format("Provided path [%s] is invalid", dir));
        }
    }
}
