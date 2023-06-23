package com.javarush.cryptanalyzer.nazarov.constants;

public class CryptoAlphabet {

    // переменные static - т.к. эти константы согласно условию задачи используются в одном экземпляре.
    private static final String rusAlphabetLowerCase = "абвгдеёжзиклмнопрстуфхцчшщъыьэюя";
    private static final String rusAlphabetUpperCase = rusAlphabetLowerCase.toUpperCase();
    private static final String digits = "0123456789";
    private static final String symbols = " .,\"':-!?";

    public static final String ALPHABET = rusAlphabetLowerCase+rusAlphabetUpperCase+digits+symbols;

}

