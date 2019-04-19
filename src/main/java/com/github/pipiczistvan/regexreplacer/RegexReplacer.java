package com.github.pipiczistvan.regexreplacer;

import com.github.pipiczistvan.regexreplacer.argument.ArgumentParser;
import com.github.pipiczistvan.regexreplacer.argument.Arguments;
import com.github.pipiczistvan.regexreplacer.eval.CommandEvaluator;
import com.github.pipiczistvan.regexreplacer.util.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplacer {

    private final Logger logger = Logger.getLogger(getClass().getName());
    private final ArgumentParser argumentParser = new ArgumentParser();
    private final CommandEvaluator commandEvaluator = new CommandEvaluator(Pattern.compile("\\$\\{(.+)\\}|\\$"));

    public void startProcessing(final String[] args) {
        // Argument parsing
        final Arguments arguments = parseArguments(args);
        if (arguments == null) {
            return;
        }

        // File scanning
        final List<File> matchingFiles = FileUtils.findFiles(arguments.getDirectory(), arguments.getFileMatcher());

        // Text replacement
        final String evaluatedReplacement = commandEvaluator.evaluateCommandsInText(arguments.getTextReplacement());
        matchingFiles.forEach(file -> replaceTextInFile(file, arguments.getTextMatcher(), evaluatedReplacement));
    }

    private Arguments parseArguments(final String[] args) {
        final Arguments arguments = argumentParser.parse(args);
        if (arguments.isHelp() || arguments.isVersion()) {
            return null;
        }

        return arguments;
    }

    private void replaceTextInFile(final File file, final String textMatcher, final String replacement) {
        PrintWriter writer = null;
        try {
            final String content = new String(Files.readAllBytes(file.toPath()));
            final String processedContent = content.replaceAll(textMatcher, replacement);

            writer = new PrintWriter(file);
            writer.println(processedContent);
            logger.info("Replaced all matching text in file: " + file.getName());
        } catch (IOException e) {
            logger.warning("Could not replace matching text in file: " + file.getName());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
