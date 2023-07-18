package com.javarush.cryptanalyzer.nazarov.view;

import java.util.Scanner;
import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.OFFERED_OPTIONS;
import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.WRONG_MODE_WARNING;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.DEFAULT_PATH_DESCRIPTION;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.DESTINATION_PATH_REQUEST;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.SOURCE_PATH_REQUEST;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.WRONG_PATH_WARNING;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericalConstants.FOUR;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericalConstants.ONE;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericalConstants.TWO;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericalConstants.ZERO;
import static com.javarush.cryptanalyzer.nazarov.utils.DefaultParametersGetter.getDefaultFirstPath;
import static com.javarush.cryptanalyzer.nazarov.utils.DefaultParametersGetter.getDefaultSecondPath;
import static com.javarush.cryptanalyzer.nazarov.utils.DictionaryGetter.getDictionary;
import static com.javarush.cryptanalyzer.nazarov.utils.KeyGetter.getKey;
import static com.javarush.cryptanalyzer.nazarov.utils.ModeValidator.modeIsOk;
import static com.javarush.cryptanalyzer.nazarov.utils.PathValidator.firstPathIsOk;
import static com.javarush.cryptanalyzer.nazarov.utils.PathValidator.secondPathIsOk;

public class ConsoleView implements View {
    @Override
    public String[] getArgs() {

        String[] args = new String[4];
        String mode, firstPath, secondPath, key;
        //selectModePrint();
        Scanner console = new Scanner(System.in);


        mode = console.next();
        while (!modeIsOk(mode)) {
            System.out.println(WRONG_MODE_WARNING + OFFERED_OPTIONS);
            mode = console.next();
        }
        args[0] = mode;


        System.out.println(SOURCE_PATH_REQUEST + getDefaultFirstPath(mode) + DEFAULT_PATH_DESCRIPTION);
        firstPath = console.next();
        while (true) {
            if (firstPath.equals(ZERO)) {
                firstPath = getDefaultFirstPath(mode);
                break;
            } else if (!firstPathIsOk(firstPath)) {
                System.out.println(WRONG_PATH_WARNING);
                firstPath = console.next();
            } else {
                break;
            }
        }
        args[1] = firstPath;


        System.out.println(DESTINATION_PATH_REQUEST + getDefaultSecondPath(mode) + DEFAULT_PATH_DESCRIPTION);
        secondPath = console.next();
        while (true) {
            if (secondPath.equals(ZERO)) {
                secondPath = getDefaultSecondPath(mode);
                break;
            } else if (!secondPathIsOk(firstPath, secondPath)) {
                System.out.println(WRONG_PATH_WARNING);
                secondPath = console.next();
            } else {
                break;
            }
        }
        args[2] = secondPath;

        args[3] = switch (mode) {
            case ONE, TWO -> getKey(console);
            case FOUR -> getDictionary(console);
            default -> ZERO;                        // тройка (брутфорс) подпадает под дефолт
        };
        console.close();
        return args;
    }
}