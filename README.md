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
regex-replacer -d "c:\Users\me\.m2\settings - Copy" -f *.xml -r "(<password>).*(<\/password>)" -t "<password>${cmd /c mvn --encrypt-password password}</password>"
```

This will replace all occurrences in every xml files in the specified directory.

You can specify the following flags:

Short form | Long form | Description | Required
--- | --- | ---
-h | --help                 | *Display help*        | NO
-v | --version              | *Display version*     | NO
-d | --directory            | *Directory*           | NO
-f | --file                 | *File matcher*        | YES
-r | --regex                | *Text matcher*        | YES
-t | --text                 | *Text replacement*    | YES
