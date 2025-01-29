package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;
import com.javarush.cryptanalyzer.nazarov.utils.PathBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.CHARS_ARRAY;
import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.CHARS_MAP;

public class BruteforceAnalyzerSpaceOriented implements Action {

    @Override
    public Result execute(String[] parameters) {

        String encodedFile = parameters[0], decodedFile = parameters[1];
        int bestSpaceCount = 0;
        int bestkey = 0;
        char space = ' ';
        for (int key = 0; key < CHARS_ARRAY.length; key++) {
            int spaceCount = countCharInFileWithKey(encodedFile, key, space);
            if (spaceCount > bestSpaceCount) {
                bestSpaceCount = spaceCount;
                bestkey = key;
            }
        }
        return rotateAndCopy(encodedFile, decodedFile, bestkey);
    }

    private int countCharInFileWithKey(String encodedFile, int key, char fixChar) {
        int spaceCount = 0;
        Path path = PathBuilder.get(encodedFile);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
        int value;
            while ((value = bufferedReader.read()) > -1) {
                char character = (char) value;
                if (CHARS_MAP.containsKey(character)) {
                    int index = CHARS_MAP.get(character);
                    index = (index + key + CHARS_ARRAY.length) % CHARS_ARRAY.length;
                    if (CHARS_ARRAY[index] == fixChar) {
                        spaceCount++;
                    }
                }
            }
        } catch (IOException e) {
            throw new AppException(e.getMessage());
        }
        return spaceCount;
    }
}
