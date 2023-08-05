package com.javarush.cryptanalyzer.nazarov.application;
import com.javarush.cryptanalyzer.nazarov.controller.MainController;
import com.javarush.cryptanalyzer.nazarov.entity.Result;
import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run() {

        String[] args = new String[]{"2", "encoded.txt", "decoded.txt", "1"}; // temp data
        // String[] args = mainController.getView().getArgs(); // return
        String mode = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        return mainController.execute(mode, parameters);
    }
}