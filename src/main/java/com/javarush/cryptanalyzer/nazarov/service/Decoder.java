package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;

import java.io.*;

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
                decodedChar = encodedChar; // вот тут подумать, если инглиш! добавить алфавит мб в енкодер?

                for (int i = 0; i < ALPHABET.length; i++) {
                    if (encodedChar == ALPHABET[i]) {
                        int newPosition = i - key < 0? i - key + ALPHABET.length : i - key;
                        decodedChar = ALPHABET[newPosition];
                    }
                }
                writer.write(decodedChar);
            }
        } catch (IOException io) {
            throw new AppException(io.getMessage());
        }
        return new Result(ResultCode.OK, "File decoded (decoded.txt)");

    }
}
