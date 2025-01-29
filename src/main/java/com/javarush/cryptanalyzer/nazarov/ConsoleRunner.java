package com.javarush.cryptanalyzer.nazarov;

import com.javarush.cryptanalyzer.nazarov.controller.MainController;
import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.view.console.ArgsGetter;
import com.javarush.cryptanalyzer.nazarov.view.console.ConsoleApp;
import java.util.Scanner;


public class ConsoleRunner {

    public static void main(String[] args) {

        // build console app
        Scanner scanner = new Scanner(System.in);
        ArgsGetter argsGetter = new ArgsGetter(); //   getArgs
        MainController mainController = new MainController();
        ConsoleApp application = new ConsoleApp(scanner, argsGetter, mainController);

        //run console app
        Result result = application.run();

    }
}

