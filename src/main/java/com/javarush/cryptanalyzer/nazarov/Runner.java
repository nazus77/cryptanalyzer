package com.javarush.cryptanalyzer.nazarov;
import com.javarush.cryptanalyzer.nazarov.application.Application;
import com.javarush.cryptanalyzer.nazarov.controller.MainController;
import com.javarush.cryptanalyzer.nazarov.view.ConsoleView;

public class Runner {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        MainController mainController = new MainController(consoleView);
        Application application = new Application(mainController);
        application.run();
    }
}

