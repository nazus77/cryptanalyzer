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

    private static int maxScore = 0;
    private static int decodedTextPosition = 0;

    @Override
    public Result execute(String[] parameters) {

        String encodedFile = parameters[0], decodedFile = parameters[1];
        List<String> list;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            list = Files.readAllLines(Path.of(encodedFile));
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, BRUTEFORCE_ERROR);
        }

        for (String s : list) {
            stringBuilder.append(s).append('\n');
        }
        list.clear();

        Map<Integer, String> textMap = getTextMap(stringBuilder);

        Map<Integer, Integer> scoresMap = getScoresMap(textMap);

        String realText = findRealText(textMap, scoresMap);

        int realKey = ALPHABET.length - decodedTextPosition;
        System.out.println(KEY_FOUND + realKey);

        try (Writer writer = new FileWriter(decodedFile)
        ) {
            writer.write(realText.toCharArray());
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, BRUTEFORCE_ERROR);
        }
        return new Result(ResultCode.OK, BRUTEFORCE_FINISHED);
    }


    private static Map<Integer, String> getTextMap(StringBuilder stringBuilder) {
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
        return textMap;
    }

    private static Map<Integer, Integer> getScoresMap(Map<Integer, String> textMap) {
        Map<Integer, Integer> scoresMap = new HashMap<>();
        int currentScore = 0;

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
        return scoresMap;
    }

    private static String findRealText(Map<Integer, String> textMap, Map<Integer, Integer> scoresMap) {
        for (var entry : scoresMap.entrySet()) {
            if (entry.getValue() == maxScore) {
                decodedTextPosition = entry.getKey();
                return textMap.get(decodedTextPosition);
            }
        }
        return textMap.get(decodedTextPosition);
    }
}

