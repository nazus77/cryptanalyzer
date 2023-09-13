package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;

import java.io.*;

import static com.javarush.cryptanalyzer.nazarov.constants.ActionsConstants.ENCODER_ERROR;
import static com.javarush.cryptanalyzer.nazarov.constants.ActionsConstants.FILE_ENCODED;
import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.ALPHABET;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        String inputFile = parameters[0], encodedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        char souceChar, encodedChar;

        try (Reader reader = new FileReader(inputFile);
             Writer writer = new FileWriter(encodedFile)
        ) {
            while (reader.ready()) {
                souceChar = (char) reader.read();
                encodedChar = souceChar;

                for (int i = 0; i < ALPHABET.length; i++) {
                    if (souceChar == ALPHABET[i]) {
                        int newIndex = i + key >= ALPHABET.length ? i + key - ALPHABET.length : i + key;
                        encodedChar = ALPHABET[newIndex];
                    }
                }
                writer.write(encodedChar);
            }
        } catch (IOException io) {
            return new Result(ResultCode.ERROR, ENCODER_ERROR);
        }
        return new Result(ResultCode.OK, FILE_ENCODED);
    }
}
