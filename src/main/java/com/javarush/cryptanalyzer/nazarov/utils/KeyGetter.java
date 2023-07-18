package com.javarush.cryptanalyzer.nazarov.utils;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.KEY_REQUEST;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.WRONG_KEY_WARNING;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericalConstants.ZERO;

public class KeyGetter {

    public static String getKey(Scanner console) {

        System.out.println(KEY_REQUEST);
        String key = console.next();

        while(true) {
        if (key.equals(ZERO)) {
            return String.valueOf(ThreadLocalRandom.current().nextInt(1, 1000));
        } else if (!keyIsOk(key)) {
            System.out.println(WRONG_KEY_WARNING);
            key = console.next();
        } else {
            return key;
        }
    }
}
    public static boolean keyIsOk(String key) {
        if (key.length() < 1 || key.length() > 4) {
            return false;
        } else {
            for (int i = 0; i < key.length(); i++) {
                if (!Character.isDigit(key.charAt(i))) {
                    return false;
                }
            }
            return Integer.parseInt(key) >= 0 && Integer.parseInt(key) <= 1000;
        }
    }
}

