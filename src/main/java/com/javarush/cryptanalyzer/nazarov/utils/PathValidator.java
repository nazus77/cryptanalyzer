package com.javarush.cryptanalyzer.nazarov.utils;

import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.TXT_EXTENSION;

public class PathValidator {

    public static boolean firstPathIsOk(String firstPath) {
        return (((firstPath.length() == 1 && Character.isDigit(firstPath.charAt(0))) && Integer.parseInt(firstPath) == 0)
                || (Files.isRegularFile(Path.of(firstPath)) && Path.of(firstPath).isAbsolute() && firstPath.endsWith(TXT_EXTENSION))
        );
    }

    public static boolean secondPathIsOk(String firstPath, String secondPath) {
        return (((secondPath.length() == 1 && Character.isDigit(secondPath.charAt(0))) && Integer.parseInt(secondPath) == 0)
                || (!firstPath.equals(secondPath) && Path.of(secondPath).isAbsolute() && Files.isDirectory(Path.of(secondPath))));
    }

//    public static boolean dictionaryIsOk(String dictionary) {
//        return (((firstPath.length() == 1 && Character.isDigit(firstPath.charAt(0))) && Integer.parseInt(firstPath) == 0)
//                || (Files.isRegularFile(Path.of(firstPath)) && Path.of(firstPath).isAbsolute() && firstPath.endsWith(TXT_EXTENSION))
//        );
//
//
//    }
}
