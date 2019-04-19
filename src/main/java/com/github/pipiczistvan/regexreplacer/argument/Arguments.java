package com.github.pipiczistvan.regexreplacer.argument;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.Strings;
import com.sun.deploy.util.StringUtils;

@Parameters(separators = "=")
public class Arguments {

    private static final String DEFAULT_DIRECTORY = ".";

    @Parameter(names = {"-h", "--help"}, description = "Show help.", help = true)
    private boolean help;

    @Parameter(names = {"-v", "--version"}, description = "Show version.", help = true)
    private boolean version;

    @Parameter(names = {"-d", "--directory"}, description = "Directory.")
    private String directory;

    @Parameter(names = {"-f", "--file"}, description = "File matcher.", required = true)
    private String fileMatcher;

    @Parameter(names = {"-r", "--regex"}, description = "Text matcher.", required = true)
    private String textMatcher;

    @Parameter(names = {"-t", "--text"}, description = "Text replacement.", required = true)
    private String textReplacement;

    public boolean isHelp() {
        return help;
    }

    public boolean isVersion() {
        return version;
    }

    public String getDirectory() {
        return Strings.isStringEmpty(directory) ? DEFAULT_DIRECTORY : directory;
    }

    public String getFileMatcher() {
        return fileMatcher;
    }

    public String getTextMatcher() {
        return textMatcher;
    }

    public String getTextReplacement() {
        return textReplacement;
    }
}
