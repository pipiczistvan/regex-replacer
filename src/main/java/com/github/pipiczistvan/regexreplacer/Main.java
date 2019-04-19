package com.github.pipiczistvan.regexreplacer;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
    }

    public static void main(final String[] args) {
        try {
            new RegexReplacer().startProcessing(args);
        } catch (Exception e) {
            LOGGER.warning("The program exited with an exception. " + e.getMessage());
        }
    }
}
