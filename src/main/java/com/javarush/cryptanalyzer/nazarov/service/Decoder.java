package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;

import java.io.*;

import static com.javarush.cryptanalyzer.nazarov.constants.ActionsConstants.DECODER_ERROR;
import static com.javarush.cryptanalyzer.nazarov.constants.ActionsConstants.FILE_DECODED;
import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.ALPHABET;

public class Decoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        String encodedFile = parameters[0], decodedFile = parameters[1], valueOfKey = parameters[2];
        int key = Integer.parseInt(valueOfKey);
        char encodedChar, decodedChar;

        try (Reader reader = new FileReader(encodedFile);
             Writer writer = new FileWriter(decodedFile)
        ) {
            while (reader.ready()) {
                encodedChar = (char) reader.read();
                decodedChar = encodedChar;

                for (int i = 0; i < ALPHABET.length; i++) {
                    if (encodedChar == ALPHABET[i]) {
                        int newIndex = i - key < 0 ? i - key + ALPHABET.length : i - key;
                        decodedChar = ALPHABET[newIndex];
                    }
                }
                writer.write(decodedChar);
            }
        } catch (IOException io) {
            return new Result(ResultCode.ERROR, DECODER_ERROR);
        }
        return new Result(ResultCode.OK, FILE_DECODED);

    }
}
