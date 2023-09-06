package com.javarush.cryptanalyzer.nazarov.utils;

import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.*;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.*;

public class DefaultPathSetter {

    public static String setDefaultFirstPath(String mode) {
        return switch (mode) {
            case ONE -> INPUT_TXT;
            case TWO, THREE, FOUR -> ENCODED_TXT;
            default -> EMPTY_STRING;
        };
    }

    public static String setDefaultSecondPath(String mode) {
        return switch (mode) {
            case ONE -> ENCODED_TXT;
            case TWO -> DECODED_TXT;
            case THREE -> DECODED_BRUTEFORCE_TXT;
            case FOUR -> DECODED_STAT_ANALYSIS_TXT;
            default -> EMPTY_STRING;
        };
    }
}
