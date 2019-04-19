Regex Replacer
====
This CLI program helps to replace text matching the specified regex with the given evaluated string in multiple files.

## Requirements

Regex Replacer has the following requirements:

* JRE 1.8 or greater.

## Installation

Download the appropriate release zip file and extract it's content to somewhere. Then add this folder to the PATH environment variable.

## Usage

Open a terminal and type:
```sh
regex-replacer -d "C:\temp files\xml" -f *.xml
```

This will replace all occurrences in every xml files in the current directory.

You can specify the following flags:

Short form | Long form | Description
--- | --- | ---
-h | --help                 | *Display help*
-v | --version              | *Display version*
