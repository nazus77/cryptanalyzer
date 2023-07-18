package com.javarush.cryptanalyzer.nazarov.application;
import com.javarush.cryptanalyzer.nazarov.controller.MainController;
import com.javarush.cryptanalyzer.nazarov.entity.Result;
import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public void run() { // вернуть возвращаемый тип - Result
        String[] args = mainController.getView().getArgs();
        String mode = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        System.out.println(Arrays.toString(args)); // временная  строка - для проверки корректного сбора аргументов от юзера

        // return mainController.execute(mode, parameters); // вернуть!

    }
}




