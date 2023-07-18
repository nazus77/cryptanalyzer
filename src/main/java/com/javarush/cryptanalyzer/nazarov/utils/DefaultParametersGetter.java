package com.javarush.cryptanalyzer.nazarov.utils;

import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.DECODED_TXT;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.EMPTY_STRING;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.ENCODED_TXT;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.INPUT_TXT;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericalConstants.FOUR;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericalConstants.ONE;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericalConstants.THREE;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericalConstants.TWO;

public class DefaultParametersGetter {

    public static String getDefaultFirstPath(String mode){
        return switch (mode) {
            case ONE -> INPUT_TXT;
            case TWO, THREE, FOUR -> ENCODED_TXT;
            default -> EMPTY_STRING;
        };
    }

    public static String getDefaultSecondPath(String mode){
        return switch (mode) {
            case ONE -> ENCODED_TXT;
            case TWO, THREE, FOUR -> DECODED_TXT;
            default -> EMPTY_STRING;
        };
    }
}
