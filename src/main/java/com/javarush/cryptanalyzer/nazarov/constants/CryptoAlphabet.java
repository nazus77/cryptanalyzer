package com.javarush.cryptanalyzer.nazarov.constants;

public class CryptoAlphabet {

    // переменные делаем static - т.к. эти константы согласно условию задачи используются в одном экземпляре.
    public static final String RUS_ALPHABET_LOWER_CASE = "абвгдеёжзиклмнопрстуфхцчшщъыьэюя";
    public static final String RUS_ALPHABET_UPPER_CASE = RUS_ALPHABET_LOWER_CASE.toUpperCase();
    public static final String DIGITS = "0123456789";
    private static final String symbols = " .,\"':-!?";
    public static final String ALPHABET = RUS_ALPHABET_LOWER_CASE + RUS_ALPHABET_UPPER_CASE + DIGITS +symbols;

    private CryptoAlphabet() {
    }
}

