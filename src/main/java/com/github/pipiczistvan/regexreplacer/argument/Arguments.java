package com.github.pipiczistvan.regexreplacer.argument;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(separators = "=")
public class Arguments {

    @Parameter(names = {"-h", "--help"}, description = "Show help.", help = true)
    private boolean help;

    @Parameter(names = {"-v", "--version"}, description = "Show version.", help = true)
    private boolean version;

    public boolean isHelp() {
        return help;
    }

    public boolean isVersion() {
        return version;
    }
}
