package com.javarush.cryptanalyzer.nazarov.application;

import com.javarush.cryptanalyzer.nazarov.controller.MainController;
import com.javarush.cryptanalyzer.nazarov.entity.Result;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    private final MainController mainController;
    final Scanner console;

    public Application(Scanner console, MainController mainController) {
        this.console = console;
        this.mainController = mainController;
    }

    public Result run() {

        String[] args = mainController.getView().getArgs();
        String mode = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        return mainController.execute(mode, parameters);
    }

    public static void resultPrinter(Result result) {
        System.out.println(result.getMessage());
    }
}