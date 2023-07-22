package com.javarush.cryptanalyzer.nazarov.application;
import com.javarush.cryptanalyzer.nazarov.controller.MainController;
import com.javarush.cryptanalyzer.nazarov.entity.Result;
import java.util.Arrays;

public class Application {

    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run() { // вернуть возвращаемый тип - Result

        String[] args = new String[]{"1", "input.txt", "decoded.txt", "3"}; // это временный архив для тестирования
        // String[] args = mainController.getView().getArgs(); раскомментировать после тестирования
        String mode = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        return mainController.execute(mode, parameters);
    }
}