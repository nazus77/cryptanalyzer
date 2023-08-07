package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.ALPHABET;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        String inputFile = parameters[0], encodedFile = parameters[1], valueOfKey = parameters[2];
        int key = Integer.parseInt(valueOfKey);
        char souceChar, encodedChar;

        try (Reader reader = new FileReader(inputFile);
             Writer writer = new FileWriter(encodedFile)
        ) {
            while (reader.ready()) {
                souceChar = (char) reader.read();
                encodedChar = souceChar;

                for (int i = 0; i < ALPHABET.length; i++) {
                    if (souceChar == ALPHABET[i]) {
                        int newPosition = i + key >= ALPHABET.length ? i + key - ALPHABET.length : i + key;
                        encodedChar = ALPHABET[newPosition];
                    }
                }
                writer.write(encodedChar);
            }
        } catch (IOException io) {
            throw new AppException(io.getMessage());
        }
        return new Result(ResultCode.OK, "File encoded (encoded.txt)");
    }
}
