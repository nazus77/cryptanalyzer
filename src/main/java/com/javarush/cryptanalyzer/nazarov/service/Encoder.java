package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        String inputFile = parameters[0];
        String encodedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return rotateAndCopy(inputFile, encodedFile, key); // а какие тут параметры в объекте Result будут?
        // у него же нет пустого конструктора.

//            return new Result(ResultCode.ERROR, ENCODER_ERROR);
//            return new Result(ResultCode.OK, FILE_ENCODED);
        }
    }
