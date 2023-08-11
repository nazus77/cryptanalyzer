package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.javarush.cryptanalyzer.nazarov.constants.ActionsConstants.*;
import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.ALPHABET;

public class BruteForceAnalyzer implements Action {

    @Override
    public Result execute(String[] parameters) {

        String encodedFile = parameters[0], decodedFile = parameters[1];
        List<String> list;

        try {
            list = Files.readAllLines(Path.of(encodedFile));
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, BRUTEFORCE_ERROR);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s).append('\n');
        }
        list.clear();

        Map<Integer, String> textMap = new HashMap<>();
        textMap.put(0, stringBuilder.toString());

        for (int i = 1; i < ALPHABET.length; i++) {
            for (int j = 0; j < stringBuilder.length(); j++) {
                for (int k = 0; k < ALPHABET.length; k++) {
                    if (stringBuilder.charAt(j) == ALPHABET[k]) {
                        int newIndex = k + 1 >= ALPHABET.length ? k + 1 - ALPHABET.length : k + 1;
                        stringBuilder.setCharAt(j, ALPHABET[newIndex]);
                        break;
                    }
                }
            }
            textMap.put(i, stringBuilder.toString());
        }

        Map<Integer, Integer> scoresMap = new HashMap<>();
        int currentScore = 0, maxScore = 0;

        for (var entry : textMap.entrySet()) {
            Integer currentTextPosition = entry.getKey();
            String value = entry.getValue();

            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == ' ') {
                    currentScore += 1;
                }
            }
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
            scoresMap.put(currentTextPosition, currentScore);
            currentScore = 0;
        }

        String realText = "";
        int decodedTextPosition = 0;

        for (var entry : scoresMap.entrySet()) {
            if (entry.getValue() == maxScore) {
                decodedTextPosition = entry.getKey();
                realText = textMap.get(decodedTextPosition);
                break;
            }
        }

        try (Writer writer = new FileWriter(decodedFile)
        ) {
            writer.write(realText.toCharArray());
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, BRUTEFORCE_ERROR);
        }

        int realKey = ALPHABET.length - decodedTextPosition;
        System.out.println(KEY_FOUND + realKey);

        return new Result(ResultCode.OK, BRUTEFORCE_FINISHED);
    }
}

