package com.javarush.cryptanalyzer.nazarov.controller;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.service.Action;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;

import static com.javarush.cryptanalyzer.nazarov.controller.Actions.find;

public class MainController {

    public Result execute(String command, String[] parameters) {
        try {

            Action action = find(command);
            // контроллер кидает в рядом расположенный энамовский метод команду,
            // чтобы тот выдал нужную имплементацию Action

            return action.execute(parameters);
            // и у этой имплементации Action вызывает ЕГО execute


        } catch (AppException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
        // эксепшн в теории нужен на случай несовпадения с именем энама

    }
}
