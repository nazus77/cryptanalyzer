package com.javarush.cryptanalyzer.nazarov.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.DICTIONARY;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.DICTIONARY_REQUEST;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.DICTIONARY_REQUIREMENTS;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.TXT_EXTENSION;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.WRONG_PATH_WARNING;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.ZERO;

public class DictionaryGetter {

    public static String getDictionary(Scanner console) {
        System.out.println(DICTIONARY_REQUEST + DICTIONARY_REQUIREMENTS);
        String dictionary = console.next();
        while (true) {
            if (dictionary.equals(ZERO)) {
                dictionary = DICTIONARY;
            } else if (!dictionaryIsOk(dictionary)) {
                System.out.println(WRONG_PATH_WARNING);
                dictionary = console.next();
            } else return dictionary;
        }
    }

    private static boolean dictionaryIsOk(String dictionary) {
        return (((dictionary.length() == 1 && Character.isDigit(dictionary.charAt(0))) && Integer.parseInt(dictionary) == 0)
                || (Files.isRegularFile(Path.of(dictionary)) && Path.of(dictionary).isAbsolute() && dictionary.endsWith(TXT_EXTENSION))
        );
    }
}
