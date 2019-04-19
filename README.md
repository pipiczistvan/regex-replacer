Regex Replacer
====
This CLI program helps to replace text matching the specified regex with the given evaluated string in multiple files.

## Requirements

Regex Replacer has the following requirements:

* JRE 1.8 or greater.

## Build
Run the following command in the project root directory:
```sh
mvn clean install
```

## Usage

Open a terminal and type:
```sh
java -jar regex-replacer.jar -d "." -f "*.xml" -p "(<password>).*(<\/password>)" -r "<password>${cmd /c mvn --encrypt-password password}</password>"
```

This will replace all occurrences in every xml files in the specified directory.

You can specify the following flags:

|Short form | Long form      | Description        | Required    |
|---------- | -------------- | ------------------ | ------------|
|-h         | --help         | *Display help*     | NO          |
|-v         | --version      | *Display version*  | NO          |
|-d         | --directory    | *Directory*        | NO          |
|-f         | --file         | *File matcher*     | YES         |
|-p         | --pattern      | *Text pattern*     | YES         |
|-r         | --replacement  | *Text replacement* | YES         |
