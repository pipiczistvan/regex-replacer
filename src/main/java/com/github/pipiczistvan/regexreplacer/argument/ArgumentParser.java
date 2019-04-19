package com.github.pipiczistvan.regexreplacer.argument;

import com.beust.jcommander.JCommander;

import java.util.logging.Logger;

public class ArgumentParser {

    private final Logger logger = Logger.getLogger(getClass().getName());

    public Arguments parse(final String[] args) {
        final Arguments arguments = new Arguments();
        final JCommander jCommander = JCommander.newBuilder().addObject(arguments).build();

        jCommander.parse(args);
        if (arguments.isHelp()) {
            jCommander.usage();
        }
        else if (arguments.isVersion()) {
            logger.info(getClass().getPackage().getImplementationVersion());
        }

        return arguments;
    }
}
