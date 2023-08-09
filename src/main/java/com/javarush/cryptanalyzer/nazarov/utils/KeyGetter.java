package com.javarush.cryptanalyzer.nazarov.utils;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.ALPHABET;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.KEY_REQUEST;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.WRONG_KEY_WARNING;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.ZERO;

public class KeyGetter {

    public static String setKey(Scanner console) {

        System.out.println(KEY_REQUEST);
        String key = console.next();

        while (true) {
            if (key.equals(ZERO)) {
                return randomKeyGenerator();
            } else if (!keyIsOk(key)) {
                System.out.println(WRONG_KEY_WARNING + KEY_REQUEST);
                key = console.next();
            } else {
                return String.valueOf(Integer.parseInt(key) % ALPHABET.length);
            }
        }
    }

    private static boolean keyIsOk(String key) {
        if (key.length() < 1 || key.length() > 4) {
            return false;
        }
        if (!isDigit(key)) {
            return false;
        }
        int value = Integer.parseInt(key);
        if (value % ALPHABET.length == 0) {
            return false;
        }
        return (value >= 0 && value <= 1000);
    }

    private static boolean isDigit(String key) {
        for (int i = 0; i < key.length(); i++) {
            if (!Character.isDigit(key.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static String randomKeyGenerator() {
        int key;
        do {
            key = ThreadLocalRandom.current().nextInt(1, 1000);
        } while (key % ALPHABET.length == 0);
        return String.valueOf(key % ALPHABET.length);
    }
}

