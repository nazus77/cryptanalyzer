package com.javarush.cryptanalyzer.nazarov.utils;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.CHARS_ARRAY;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.*;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.ZERO;

public class KeySetter {

    public static String setKey(Scanner scanner) {

        System.out.println(KEY_REQUEST);
        String key = scanner.next();

        while (true) {
            if (key.equals(ZERO)) {
                return randomKeyGenerator();
            } else if (!keyIsOk(key)) {
                System.out.println(WRONG_KEY_WARNING + KEY_REQUEST);
                key = scanner.next();
            } else {
                return String.valueOf(Integer.parseInt(key) % CHARS_ARRAY.length);
            }
        }
    }

    private static boolean keyIsOk(String key) {
        if (key.isEmpty() || key.length() > 4) {
            return false;
        }
        if (!isDigit(key)) {
            return false;
        }
        int value = Integer.parseInt(key);
        if (value % CHARS_ARRAY.length == 0) {
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
            key = ThreadLocalRandom.current().nextInt(-1000, 1000);
        } while (key % CHARS_ARRAY.length == 0);
        System.out.println(RANDOM_KEY + key);
        return String.valueOf(key);
    }
}

