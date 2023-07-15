package com.javarush.cryptanalyzer.nazarov.utils;

import java.util.Scanner;

import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.CHOOSEMODE0;
import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.CHOOSEMODE1;
import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.CHOOSEMODE2;
import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.CHOOSEMODE3;
import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.CHOOSEMODE4;
import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.CHOOSEMODE5;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.DESTINATION_PATH_REQUEST;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.ENCRYPTED_PATH;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.INPUT_PATH;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.KEY_REQUEST;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.KEY_WARNING;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.OUTPUT_PATH;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.SOURCE_PATH_REQUEST;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.WRONG_PATH_WARNING;
import static com.javarush.cryptanalyzer.nazarov.utils.PathChecker.absolutePathCheck;
import static com.javarush.cryptanalyzer.nazarov.utils.PathChecker.directoryExistsCheck;
import static com.javarush.cryptanalyzer.nazarov.utils.PathChecker.fileExistsCheck;
import static com.javarush.cryptanalyzer.nazarov.utils.PathChecker.fileTxtExtensionCheck;
import static com.javarush.cryptanalyzer.nazarov.utils.KeyChecker.keyCheck;

public class UserInputSolver {
    public static String getMode() throws InterruptedException {

        System.out.println(CHOOSEMODE0);
        //Thread.sleep(500);
        System.out.println(CHOOSEMODE1);
        //Thread.sleep(500);
        System.out.println(CHOOSEMODE2);
        //Thread.sleep(500);
        System.out.println(CHOOSEMODE3);
        // Thread.sleep(500);
        System.out.println(CHOOSEMODE4);
        // Thread.sleep(500);
        System.out.println(CHOOSEMODE5);

        Scanner console = new Scanner(System.in);
        String mode;

        while (true) {
            mode = console.nextLine();
            if (mode.length() != 1 && !Character.isDigit(mode.charAt(0))) {
                System.out.println("plase, choose from the offered options");
                continue;
            }
            int modeInt = Integer.parseInt(mode);
            if (modeInt < 0 || modeInt > 5) {
                System.out.println("plase, choose from the offered options");
            } else {
                console.close(); // не забываем закрывать сканер
                return mode;
            }
        }
    }


    public static String[] getParameters(String command) {

        String[] parameters = new String[3];
        parameters[0] = getFirstParameter(command);
        parameters[1] = getSecondParameter(command);
        parameters[2] = getKey(command);
        return parameters;
    }

    private static String getFirstParameter(String command) {

            Scanner console = new Scanner(System.in);
            System.out.println(SOURCE_PATH_REQUEST + getDefaultFirstParameter(command));
            String firstParameter = console.nextLine();

            while (!(fileExistsCheck(firstParameter) && absolutePathCheck(firstParameter) && fileTxtExtensionCheck(firstParameter))) {
            if (firstParameter.equals("")) {
                firstParameter = getDefaultFirstParameter(command);
                break;
            } else {
                System.out.println(WRONG_PATH_WARNING + "\n" + SOURCE_PATH_REQUEST + getDefaultFirstParameter(command));
                firstParameter = new Scanner(System.in).nextLine();
            }
        }
        return firstParameter;
    }

    private static String getDefaultFirstParameter(String command) {
        return switch (command) {
            case "1" -> INPUT_PATH;
            case "2", "3", "4" -> ENCRYPTED_PATH;
            default -> "";
        };
    }


    private static String getSecondParameter(String command) {

        System.out.println(DESTINATION_PATH_REQUEST + getDefaultSecondParameter(command));
        String secondParameter = new Scanner(System.in).nextLine();

        if (secondParameter.equals("")) {
            return getDefaultSecondParameter(command);
        } else {
            while (!(directoryExistsCheck(secondParameter) && absolutePathCheck(secondParameter))) {
                System.out.println(WRONG_PATH_WARNING + "\n" + DESTINATION_PATH_REQUEST + getDefaultSecondParameter(command));
                secondParameter = new Scanner(System.in).nextLine();
            }
        }
        return secondParameter;
    }

    private static String getDefaultSecondParameter(String command) {
        return switch (command) {
            case "1" -> ENCRYPTED_PATH;
            case "2", "3", "4" -> OUTPUT_PATH;
            default -> "";
        };
    }

    private static String getKey(String command) {

        Scanner console = new Scanner(System.in);
        if (command.equals("3") || command.equals("4")) {
            return "0";
            //TODO здесь  поменять на свитч и чуть ниже реализовать метод проверки ключа (целое число больше
        }
        System.out.println(KEY_REQUEST);
        int key = console.nextInt(); //TODO здесь поменять не стринг, т.к. ввести могут дробное. Поменять

        while (!keyCheck(key)) {
            System.out.println(KEY_WARNING + "\n " + KEY_REQUEST);
            key = console.nextInt();
        }
        return String.valueOf(key);
    }
}

