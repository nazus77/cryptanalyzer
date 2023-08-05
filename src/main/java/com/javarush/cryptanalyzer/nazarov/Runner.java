package com.javarush.cryptanalyzer.nazarov;
import com.javarush.cryptanalyzer.nazarov.application.Application;
import com.javarush.cryptanalyzer.nazarov.controller.MainController;
import com.javarush.cryptanalyzer.nazarov.view.ConsoleView;
import com.javarush.cryptanalyzer.nazarov.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        application.run();
    }
}

