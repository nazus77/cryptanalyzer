package com.javarush.cryptanalyzer.nazarov.utils;

import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.GOODBYE;

public class ModeValidator {

    public static boolean modeIsOk(String mode) {

        if (!(Character.isDigit(mode.charAt(0)) && mode.length() == 1)) {
            return false;
        }

        int modeInt = Integer.parseInt(mode);
        if (modeInt < 0 || modeInt > 4) {
            return false;
        } else if (modeInt == 0) {
            System.out.println(GOODBYE);
            System.exit(0);
        }
        return true;
    }
}
