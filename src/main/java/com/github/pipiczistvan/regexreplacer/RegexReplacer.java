package com.github.pipiczistvan.regexreplacer;

import com.github.pipiczistvan.regexreplacer.argument.ArgumentParser;
import com.github.pipiczistvan.regexreplacer.argument.Arguments;
import com.github.pipiczistvan.regexreplacer.util.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Logger;

public class RegexReplacer {

    private final Logger logger = Logger.getLogger(getClass().getName());
    private final ArgumentParser argumentParser = new ArgumentParser();

    public void startProcessing(final String[] args) {
        // Argument parsing
        final Arguments arguments = parseArguments(args);
        if (arguments == null) {
            return;
        }

        // File scanning
        final List<File> matchingFiles = FileUtils.findFiles(arguments.getDirectory(), arguments.getFileMatcher());

        matchingFiles.forEach(file -> replaceTextInFile(file, arguments.getTextMatcher(), arguments.getTextReplacement()));
    }

    private Arguments parseArguments(final String[] args) {
        final Arguments arguments = argumentParser.parse(args);
        if (arguments.isHelp() || arguments.isVersion()) {
            return null;
        }

        return arguments;
    }

    private void replaceTextInFile(final File file, final String textMatcher, final String replacement) {
        String content;
        try {
            content = new String(Files.readAllBytes(file.toPath()));
            content = content.replaceAll(textMatcher, replacement);
        } catch (IOException e) {
            logger.warning("Could not replace matching text in file: " + file.getName());
            return;
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(content);
            logger.info("Replaced all matching text in file: " + file.getName());
        } catch (IOException e) {
            logger.warning("Could not save file: " + file.getName());
        }
    }
}
