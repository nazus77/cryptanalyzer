package com.javarush.cryptanalyzer.nazarov.view.console;

import java.util.Scanner;

import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.INCORRECT_CHARACTER_WARNING;
import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.OFFERED_OPTIONS;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.*;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.*;
import static com.javarush.cryptanalyzer.nazarov.utils.DefaultPathSetter.setDefaultFirstPath;
import static com.javarush.cryptanalyzer.nazarov.utils.DefaultPathSetter.setDefaultSecondPath;
import static com.javarush.cryptanalyzer.nazarov.utils.DictionarySetter.setDictionary;
import static com.javarush.cryptanalyzer.nazarov.utils.KeySetter.setKey;
import static com.javarush.cryptanalyzer.nazarov.utils.ModeValidator.modeIsOk;
import static com.javarush.cryptanalyzer.nazarov.utils.PathValidator.firstPathIsOk;
import static com.javarush.cryptanalyzer.nazarov.utils.PathValidator.secondPathIsOk;
import static com.javarush.cryptanalyzer.nazarov.utils.SelectModePrinter.selectModePrint;

public class ArgsGetter {

    public String[] getArgs(Scanner console) {

        String[] args = new String[4];
        String mode, firstPath, secondPath;
        selectModePrint();

        mode = console.nextLine();
        while (!modeIsOk(mode)) {
            System.out.println(INCORRECT_CHARACTER_WARNING + OFFERED_OPTIONS);
            mode = console.nextLine();
        }
        args[0] = mode;

        // досюда ок. empty String - возвращает false (incorrect input

        System.out.println(SOURCE_PATH_REQUEST + setDefaultFirstPath(mode) + DEFAULT_PATH_DESCRIPTION);
        firstPath = console.nextLine();
        while (true) {
            if (firstPath.equals(ZERO)) {
                firstPath = setDefaultFirstPath(mode);
                break;
            } else if (!firstPathIsOk(firstPath)) {
                System.out.println(WRONG_PATH_WARNING);
                firstPath = console.nextLine();
            } else {
                break;
            }
        }
        args[1] = firstPath;

        System.out.println(DESTINATION_PATH_REQUEST + setDefaultSecondPath(mode) + DEFAULT_PATH_DESCRIPTION);
        secondPath = console.nextLine();

        while (true) {
            if (secondPath.equals(ZERO)) {
                secondPath = setDefaultSecondPath(mode);
                break;
            } else if (!secondPathIsOk(firstPath, secondPath, console)) {
                System.out.println(WRONG_PATH_WARNING);
                secondPath = console.nextLine();
            } else {
                break;
            }
        }
        args[2] = secondPath;

        args[3] = switch (mode) {
            case ONE, TWO -> setKey(console);
            case FOUR -> setDictionary(console);
            default -> ZERO;
        };

        console.close();
        return args;
    }
}
