package com.github.pipiczistvan.regexreplacer;

import com.github.pipiczistvan.regexreplacer.argument.ArgumentParser;
import com.github.pipiczistvan.regexreplacer.argument.Arguments;
import com.github.pipiczistvan.regexreplacer.util.FileUtils;

import java.io.File;
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
    }

    private Arguments parseArguments(final String[] args) {
        final Arguments arguments = argumentParser.parse(args);
        if (arguments.isHelp() || arguments.isVersion()) {
            return null;
        }

        return arguments;
    }
}
