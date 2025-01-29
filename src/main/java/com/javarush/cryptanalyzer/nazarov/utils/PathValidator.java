package com.javarush.cryptanalyzer.nazarov.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.INCORRECT_CHARACTER_WARNING;
import static com.javarush.cryptanalyzer.nazarov.constants.GetParametersConstants.*;

public class PathValidator {

    public static boolean firstPathIsOk(String firstPath) {
        return (((firstPath.length() == 1 && Character.isDigit(firstPath.charAt(0))) && Integer.parseInt(firstPath) == 0)
                || (Files.isRegularFile(Path.of(firstPath)) && Path.of(firstPath).isAbsolute() && firstPath.endsWith(TXT_EXTENSION))
        );
    }

    public static boolean secondPathIsOk(String firstPath, String secondPath, Scanner console) {
        if (firstPath.equals(secondPath)) {
            System.out.println(SAME_DESTINATION_WARNING);
            return false;
        } else if (Files.isRegularFile(Path.of(secondPath))) {
            System.out.println(FILE_EXISTS_WARNING + YES_NO);
            return overWrite(console);
        } else {
            return (((firstPath.length() == 1 && Character.isDigit(firstPath.charAt(0))) && Integer.parseInt(firstPath) == 0)
                    || Path.of(secondPath).isAbsolute()
                    && firstPath.endsWith(TXT_EXTENSION));
        }
    }

    private static boolean overWrite(Scanner scanner) {
        String answer;
        while (true) {
            answer = scanner.next();
            if (answer.equals("1")) {
                return true;
            } else if (answer.equals("2")) {
                return false;
            } else {
                System.out.println(INCORRECT_CHARACTER_WARNING + YES_NO);
            }
        }
    }
}
