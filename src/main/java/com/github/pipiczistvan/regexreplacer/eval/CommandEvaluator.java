package com.github.pipiczistvan.regexreplacer.eval;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandEvaluator {

    private final Pattern commandPattern;
    private final Logger logger = Logger.getLogger(getClass().getName());

    public CommandEvaluator(final Pattern commandPattern) {
        this.commandPattern = commandPattern;
    }

    public String evaluateCommandsInText(final String text) {
        if (text == null) {
            return null;
        }

        final Matcher commandMatcher = commandPattern.matcher(text);
        final StringBuffer resolvedTextBuffer = new StringBuffer();
        while (commandMatcher.find()) {
            final String command = commandMatcher.group(1);
            final String evaluation = evaluate(command);

            if (evaluation == null) {
                logger.warning("Could not evaluate command: " + command);
                break;
            }
            commandMatcher.appendReplacement(resolvedTextBuffer, Matcher.quoteReplacement(evaluation));
        }
        commandMatcher.appendTail(resolvedTextBuffer);

        return resolvedTextBuffer.toString();
    }

    private String evaluate(final String command) {
        try {
            final Process process = Runtime.getRuntime().exec(command);
            final BufferedReader inStreamReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            final StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = inStreamReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            logger.warning("Could not execute command argument");
            return null;
        }
    }
}
