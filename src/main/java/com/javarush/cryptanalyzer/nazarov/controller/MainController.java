package com.javarush.cryptanalyzer.nazarov.controller;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;
import com.javarush.cryptanalyzer.nazarov.service.Action;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.*;
import static com.javarush.cryptanalyzer.nazarov.controller.ActionIncubatorConstants.*;

public class MainController {

    public MainController() {
    }

    public Result doAction(String mode, String[] parameters) {

        try {
            Action action = getAction(mode);
            return action.execute(parameters);

        } catch (RuntimeException e) {
            return new Result(ResultCode.ERROR);
        }
    }

    public com.javarush.cryptanalyzer.nazarov.service.Action getAction(String mode) {
        return switch (mode) {
            case ONE -> ActionIncubator.valueOf(ENCODER).getActionIncubatorValue();
            case TWO -> ActionIncubator.valueOf(DECODER).getActionIncubatorValue();
            case THREE -> ActionIncubator.valueOf(BRUTEFORCE_ANALYZER).getActionIncubatorValue();
            case FOUR -> ActionIncubator.valueOf(STATISTICAL_ANALYZER).getActionIncubatorValue();
            default -> throw new AppException();
        };
    }
}
