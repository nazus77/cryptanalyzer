package com.javarush.cryptanalyzer.nazarov.view;

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

public class ConsoleView implements View {
    @Override
    public String[] getArgs() {

        String[] args = new String[4];
        String mode, firstPath, secondPath;
        selectModePrint();
        Scanner console = new Scanner(System.in);

        mode = console.next();
        while (!modeIsOk(mode)) {
            System.out.println(INCORRECT_CHARACTER_WARNING + OFFERED_OPTIONS);
            mode = console.next();
        }
        args[0] = mode;

        System.out.println(SOURCE_PATH_REQUEST + setDefaultFirstPath(mode) + DEFAULT_PATH_DESCRIPTION);
        firstPath = console.next();
        while (true) {
            if (firstPath.equals(ZERO)) {
                firstPath = setDefaultFirstPath(mode);
                break;
            } else if (!firstPathIsOk(firstPath)) {
                System.out.println(WRONG_PATH_WARNING);
                firstPath = console.next();
            } else {
                break;
            }
        }
        args[1] = firstPath;

        System.out.println(DESTINATION_PATH_REQUEST + setDefaultSecondPath(mode) + DEFAULT_PATH_DESCRIPTION);
        secondPath = console.next();

        while (true) {
            if (secondPath.equals(ZERO)) {
                secondPath = setDefaultSecondPath(mode);
                break;
            } else if (!secondPathIsOk(firstPath, secondPath, console)) {
                System.out.println(WRONG_PATH_WARNING);
                secondPath = console.next();
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
