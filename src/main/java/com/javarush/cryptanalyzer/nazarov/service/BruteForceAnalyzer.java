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
import static com.javarush.cryptanalyzer.nazarov.constants.StatusConstants.*;
import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.CHARS_ARRAY;

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
            return new Result(ResultCode.ERROR);
        }

        for (String s : list) {
            stringBuilder.append(s).append('\n');
        }
        list.clear();

        Map<Integer, String> textMap = getTextMap(stringBuilder);
        Map<Integer, Integer> scoresMap = getScoresMap(textMap);
        String realText = findRealText(textMap, scoresMap);

        int realKey = CHARS_ARRAY.length - decodedTextPosition;
        System.out.println(KEY_FOUND + realKey);

        try (Writer writer = new FileWriter(decodedFile)
        ) {
            writer.write(realText.toCharArray());
        } catch (IOException e) {
            return new Result(ResultCode.ERROR);
        }
        return new Result(ResultCode.OK);
    }


    private static Map<Integer, String> getTextMap(StringBuilder stringBuilder) {
        Map<Integer, String> textMap = new HashMap<>();
        textMap.put(0, stringBuilder.toString());


        // сложность О от N в кубе!
        for (int i = 1; i < CHARS_ARRAY.length; i++) {
            for (int j = 0; j < stringBuilder.length(); j++) {
                for (int k = 0; k < CHARS_ARRAY.length; k++) {
                    if (stringBuilder.charAt(j) == CHARS_ARRAY[k]) {
                        int newIndex = k + 1 >= CHARS_ARRAY.length ? k + 1 - CHARS_ARRAY.length : k + 1;
                        stringBuilder.setCharAt(j, CHARS_ARRAY[newIndex]);
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

        // сложность О от N в квадрате!
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

