package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.cryptanalyzer.nazarov.constants.ActionsConstants.STAT_ANALYSIS_FINISHED;
import static com.javarush.cryptanalyzer.nazarov.constants.ActionsConstants.STAT_ANALYZER_ERROR;

public class StatisticalAnalyzer implements Action {
    @Override
    public Result execute(String[] parameters) {

        String encodedFile = parameters[0], decodedFile = parameters[1], dictionary = parameters[2];
        Map<Character, Double> encodedTextStat = new HashMap<>(), dictionaryStat = new HashMap<>();

        StringBuilder stringBuilder1 = new StringBuilder(), stringBuilder2 = new StringBuilder();

        try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader(encodedFile));
             BufferedReader bufferedReader2 = new BufferedReader(new FileReader(dictionary))) {


            // ОБРАБАТЫВАЕМ ЗАКОДИРОВАННЫЙ ТЕКСТ
            while (bufferedReader1.ready()) {
                stringBuilder1.append(bufferedReader1.readLine()).append('\n');
            }
            for (int i = 0; i < stringBuilder1.length(); i++) {
                encodedTextStat.put(stringBuilder1.charAt(i), getStat(stringBuilder1.charAt(i), stringBuilder1));
            }

            // ОБРАБАТЫВАЕМ СЛОВАРЬ
            while (bufferedReader2.ready()) {
                stringBuilder2.append(bufferedReader2.readLine()).append('\n');
            }
            for (int i = 0; i < stringBuilder2.length(); i++) {
                dictionaryStat.put(stringBuilder2.charAt(i), getStat(stringBuilder2.charAt(i), stringBuilder2));
            }






            /*
            // РАСПЕЧАТКА СТАТИСТИКИ ПО ЗАКОДИРОВАННОМУ ТЕКСТУ. ПОТОМ УДАЛИТЬ
            double sum1 = 0.0;
            for (var entry : encodedTextStat.entrySet()) {
                System.out.print(entry.getKey() + " = ");
                System.out.println(entry.getValue());
                sum1 += entry.getValue();
            }
            System.out.println(sum1);
            // РАСПЕЧАТКА СТАТИСТИКИ ПО СЛОВАРЮ. ПОТОМ УДАЛИТЬ
            double sum2 = 0.0;
            for (var entry : dictionaryStat.entrySet()) {
                System.out.print(entry.getKey() + " = ");
                System.out.println(entry.getValue());
                sum2 += entry.getValue();
            }
            System.out.println(sum2);
            */


        } catch (IOException e) {
            return new Result(ResultCode.ERROR, STAT_ANALYZER_ERROR);
        }




        //TODO: finalize statistic analysis




        return new Result(ResultCode.OK, STAT_ANALYSIS_FINISHED);
    }


    private static Double getStat(Character character, StringBuilder stringBuilder) {
        int counter = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (character == stringBuilder.charAt(i)) {
                counter += 1;
            }
        }
        return (counter / (double) stringBuilder.length()) * 100;
    }
}
