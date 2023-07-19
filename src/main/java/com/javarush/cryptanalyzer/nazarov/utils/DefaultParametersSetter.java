package com.javarush.cryptanalyzer.nazarov.utils;

import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.DECODED_TXT;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.EMPTY_STRING;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.ENCODED_TXT;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.INPUT_TXT;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.FOUR;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.ONE;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.THREE;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.TWO;

public class DefaultParametersSetter {

    public static String setDefaultFirstPath(String mode){
        return switch (mode) {
            case ONE -> INPUT_TXT;
            case TWO, THREE, FOUR -> ENCODED_TXT;
            default -> EMPTY_STRING;
        };
    }

    public static String setDefaultSecondPath(String mode){
        return switch (mode) {
            case ONE -> ENCODED_TXT;
            case TWO, THREE, FOUR -> DECODED_TXT;
            default -> EMPTY_STRING;
        };
    }
}
