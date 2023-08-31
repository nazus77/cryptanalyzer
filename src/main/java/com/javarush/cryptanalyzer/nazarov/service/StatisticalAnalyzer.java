package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.cryptanalyzer.nazarov.constants.ActionsConstants.*;

public class StatisticalAnalyzer implements Action {
    @Override
    public Result execute(String[] parameters) {

        String encodedFile = parameters[0], decodedFile = parameters[1], dictionary = parameters[2];
        Map<Character, Double> encodedTextStat = new HashMap<>(), dictionaryStat = new HashMap<>();
        StringBuilder encodedText = new StringBuilder(), dictionaryText = new StringBuilder();
        System.out.println(PLEASE_WAIT);

        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(encodedFile));
             BufferedReader bufferedReader2 = new BufferedReader(new FileReader(dictionary));
             FileWriter fileWriter = new FileWriter(decodedFile)) {

            while (bufferedReader1.ready()) {
                encodedText.append(bufferedReader1.readLine()).append('\n');
            }
            for (int i = 0; i < encodedText.length(); i++) {
                encodedTextStat.put(encodedText.charAt(i), getStat(encodedText.charAt(i), encodedText));
            }

            while (bufferedReader2.ready()) {
                dictionaryText.append(bufferedReader2.readLine()).append('\n');
            }
            for (int i = 0; i < dictionaryText.length(); i++) {
                dictionaryStat.put(dictionaryText.charAt(i), getStat(dictionaryText.charAt(i), dictionaryText));
            }

            StringBuilder finalText = new StringBuilder();
            finalText.append(encodedText);

            for (var entry : encodedTextStat.entrySet()) {
                for (int i = 0; i < encodedText.length(); i++) {
                    if (entry.getKey() == encodedText.charAt(i)) {
                        finalText.setCharAt(i, getReplacedChar(entry.getValue(), dictionaryStat));
                    }
                }
            }
            fileWriter.write(finalText.toString());

        } catch (IOException e) {
            return new Result(ResultCode.ERROR, STAT_ANALYZER_ERROR);
        }

        return new Result(ResultCode.OK, STAT_ANALYSIS_FINISHED);
    }

    private static Double getStat(Character character, StringBuilder stringBuilder) {
        int counter = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (character == stringBuilder.charAt(i)) {
                counter += 1;
            }
        }
        return ((counter / (double) stringBuilder.length()) * 100);
    }

    private static char getReplacedChar(Double stat, Map<Character, Double> dictionaryStat) {
        char replacedChar = ' ';
        double minDifference = Double.MAX_VALUE, currentDifference;

        for (var entry : dictionaryStat.entrySet()) {
            if (Double.max(stat, entry.getValue()) == stat) {
                currentDifference = stat - entry.getValue();
            } else {
                currentDifference = entry.getValue() - stat;
            }

            if (currentDifference < minDifference) {
                minDifference = currentDifference;
                replacedChar = entry.getKey();
            }
        }

        return replacedChar;
    }

}

/*
// encodedText print stats
            double sum1 = 0.0;
            for (var entry : encodedTextStat.entrySet()) {
                System.out.print(entry.getKey() + " = ");
                System.out.println(entry.getValue());
                sum1 += entry.getValue();
            }
            System.out.println(sum1);

// dictionary print stats
            double sum2 = 0.0;
            for (var entry : dictionaryStat.entrySet()) {
                System.out.print(entry.getKey() + " = ");
                System.out.println(entry.getValue());
                sum2 += entry.getValue();
            }
            System.out.println(sum2);
 */


