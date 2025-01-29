package com.javarush.cryptanalyzer.nazarov.constants;

import java.util.HashMap;
import java.util.Map;

public class CryptoAlphabet {

    private static final String rusLettersUpperCase = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String rusLettersLowerCase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String digits = "0123456789";
    private static final String symbols = ".,“”\":-!? ";
    public static final char[] CHARS_ARRAY = (rusLettersUpperCase + rusLettersLowerCase + digits + symbols).toCharArray();
    public static final Map<Character, Integer> CHARS_MAP = new HashMap<>();

    static {
        for (int i = 0; i < CHARS_ARRAY.length; i++) {
            CHARS_MAP.put(CHARS_ARRAY[i], i);
        }
    }

    private CryptoAlphabet() {
    }
}


