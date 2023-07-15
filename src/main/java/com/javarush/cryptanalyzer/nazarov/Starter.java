package com.javarush.cryptanalyzer.nazarov;

import com.javarush.cryptanalyzer.nazarov.application.Application;

// EntryPoint
public class Starter {

    public static void main(String[] args) {

        // MainController mainController = new MainController(); удалим его тут, создадим в аппликейшене

        Application application = new Application();
        application.run();

    }
}

