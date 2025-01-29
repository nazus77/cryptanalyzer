package com.javarush.cryptanalyzer.nazarov.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.*;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.ZERO;

public class DictionarySetter {

    public static String setDictionary(Scanner scanner) {
        System.out.println(DICTIONARY_REQUEST + DICTIONARY_REQUIREMENTS);
        String dictionary = scanner.nextLine();
        while (true) {
            if (dictionary.equals(ZERO)) {
                return DICTIONARY;
            } else if (!dictionaryIsOk(dictionary)) {
                System.out.println(WRONG_PATH_WARNING);
                dictionary = scanner.nextLine();
            } else return dictionary;
        }
    }

    private static boolean dictionaryIsOk(String dictionary) {
        return (((dictionary.length() == 1 && Character.isDigit(dictionary.charAt(0))) && Integer.parseInt(dictionary) == 0)
                || (Files.isRegularFile(Path.of(dictionary)) && Path.of(dictionary).isAbsolute() && dictionary.endsWith(TXT_EXTENSION))
        );
    }
}