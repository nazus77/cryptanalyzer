package com.javarush.cryptanalyzer.nazarov.controller;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;
import com.javarush.cryptanalyzer.nazarov.service.Action;
import com.javarush.cryptanalyzer.nazarov.view.View;

import static com.javarush.cryptanalyzer.nazarov.constants.ActionIncubatorConstants.*;
import static com.javarush.cryptanalyzer.nazarov.constants.NumericConstants.*;

public class MainController {
    View view;

    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public Result execute(String mode, String[] parameters) {

        try {
            Action action = getAction(mode);
            return action.execute(parameters);
        } catch (RuntimeException e) {
            return new Result(ResultCode.ERROR, e.getMessage());
        }
    }

    public Action getAction(String mode) {
        return switch (mode) {

            case ONE -> ActionIncubator.valueOf(ENCODER).getActionIncubatorValue();
            case TWO -> ActionIncubator.valueOf(DECODER).getActionIncubatorValue();
            case THREE -> ActionIncubator.valueOf(BRUTEFORCEANALYZER).getActionIncubatorValue();
            case FOUR -> ActionIncubator.valueOf(STATISTICALANALYZER).getActionIncubatorValue();
            default -> throw new AppException();
        };
    }
}
