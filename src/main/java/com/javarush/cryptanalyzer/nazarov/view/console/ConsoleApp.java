package com.javarush.cryptanalyzer.nazarov.view.console;

import com.javarush.cryptanalyzer.nazarov.controller.MainController;
import com.javarush.cryptanalyzer.nazarov.entity.Result;

import java.util.Arrays;
import java.util.Scanner;

public class ConsoleApp {

    private final MainController mainController;
    private final ArgsGetter argsGetter;
    final Scanner scanner;

    public ConsoleApp(Scanner scanner, ArgsGetter argsGetter, MainController mainController) {
        this.scanner = scanner;
        this.argsGetter = argsGetter;
        this.mainController = mainController;
    }

    public Result run() {
        String[] args = argsGetter.getArgs(scanner);
        String mode = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        Result result = mainController.doAction(mode, parameters);
        System.out.println(result.toString());
        return result;
    }
}