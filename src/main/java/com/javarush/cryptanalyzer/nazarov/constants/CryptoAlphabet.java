package com.javarush.cryptanalyzer.nazarov.constants;

public class CryptoAlphabet {

    private static final String rusLettersUpperCase = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String rusLettersLowerCase = "абвгдеёжзиклмнопрстуфхцчшщъыьэюя";
    private static final String digits = "0123456789";
    private static final String symbols = ".,\"\":-!? ";
    public static final char[] ALPHABET = (rusLettersUpperCase + rusLettersLowerCase + digits +symbols).toCharArray();

    private CryptoAlphabet() {
    }
}


