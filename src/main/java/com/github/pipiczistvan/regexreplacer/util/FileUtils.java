package com.github.pipiczistvan.regexreplacer.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileUtils {

    private static final Logger LOGGER = Logger.getLogger(FileUtils.class.getName());

    private FileUtils() {
    }

    public static List<File> findFiles(final String directory, final String fileMatcher) {
        final List<File> matchingFiles = new ArrayList<>();

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Paths.get(directory), fileMatcher)) {
            dirStream.forEach(path -> {
                final File file = path.toFile();
                if (file.isFile()) {
                    matchingFiles.add(file);
                }
            });
        } catch (IOException e) {
            LOGGER.warning("Could not find files in directory: " + directory);
            LOGGER.warning(e.getMessage());
        }

        return matchingFiles;
    }
}
