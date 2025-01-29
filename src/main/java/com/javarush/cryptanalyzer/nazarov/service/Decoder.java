package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;

public class Decoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        String encodedFile = parameters[0];
        String decodedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        return rotateAndCopy(encodedFile, decodedFile, -1 * key);

//      return new Result(ResultCode.ERROR, DECODER_ERROR);
//      return new Result(ResultCode.OK, FILE_DECODED);

    }
}
