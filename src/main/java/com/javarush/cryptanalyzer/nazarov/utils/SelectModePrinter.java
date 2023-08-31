package com.javarush.cryptanalyzer.nazarov.utils;

import com.javarush.cryptanalyzer.nazarov.exception.AppException;
import static com.javarush.cryptanalyzer.nazarov.constants.GetModeConstants.*;

public class SelectModePrinter {

    public static void selectModePrint() {
        try {
            System.out.println(WELCOME);
            Thread.sleep(350);
            System.out.println(MODE_SELECT_1);
            Thread.sleep(350);
            System.out.println(MODE_SELECT_2);
            Thread.sleep(350);
            System.out.println(MODE_SELECT_3);
            Thread.sleep(350);
            System.out.println(MODE_SELECT_4);
            Thread.sleep(350);
            System.out.println(MODE_SELECT_0);
        } catch (InterruptedException e) {
            throw new AppException(e);
        }

    }
}
