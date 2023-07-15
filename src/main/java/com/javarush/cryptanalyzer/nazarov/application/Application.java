package com.javarush.cryptanalyzer.nazarov.application;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;

import java.util.Arrays;

import static com.javarush.cryptanalyzer.nazarov.utils.UserInputSolver.getMode;
import static com.javarush.cryptanalyzer.nazarov.utils.UserInputSolver.getParameters;
//import static com.javarush.cryptanalyzer.nazarov.view.GetDataFromUser.getParameters;

public class Application {

//    private final MainController mainController;
//
//    public Application(MainController mainController) {
//        this.mainController = mainController;
//    }

    public Result run() {

        String command;
        try {
            command = getMode();
        } catch (InterruptedException e) {
            throw new AppException(e); //TODO уточнить, что лучше выкинуть
        }

        //TODO поймаем тут НОЛЬ, пишем гудбай и завершаем программу

        String[] parameters = getParameters(command);

        System.out.println(Arrays.toString(parameters));

        //return new MainController().execute(command, parameters);
        return null;
    }
}
