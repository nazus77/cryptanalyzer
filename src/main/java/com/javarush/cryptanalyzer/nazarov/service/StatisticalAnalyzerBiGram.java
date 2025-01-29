package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;
import com.javarush.cryptanalyzer.nazarov.utils.PathBuilder;
import com.javarush.cryptanalyzer.nazarov.utils.BiGramStatistics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.CHARS_ARRAY;

public class StatisticalAnalyzerBiGram implements Action {

    public static final int COUNT_TRY_FIND = 10;

    @Override
    public Result execute(String[] parameters) {
        String encryptedFilename = parameters[0];
        String dictionaryFilename = parameters[1];
        String analyzedFilename = parameters[2];

        List<Character> dictChar = getCharacterList(CHARS_ARRAY);
        List<Character> sourceChar = findBestVersionAlphabet(encryptedFilename, dictionaryFilename);

        Path source = PathBuilder.get(encryptedFilename);
        Path target = PathBuilder.get(analyzedFilename);
        try (
                BufferedReader reader = Files.newBufferedReader(source);
                BufferedWriter writer = Files.newBufferedWriter(target)
        ) {
            int value;
            while ((value = reader.read()) > -1) {
                char character = (char) value;
                int index = sourceChar.indexOf(character);
                Character characterDecrypted = dictChar.get(index);
                writer.write(
                        characterDecrypted != null
                                ? characterDecrypted
                                : character);
            }
        } catch (IOException e) {
            throw new AppException(e.getMessage(), e);
        }
        return new Result(ResultCode.OK);
    }

    private List<Character> findBestVersionAlphabet(String encryptedFilename, String dictionaryFilename) {
        double[][] matrix = BiGramStatistics.getBiGramStat(PathBuilder.get(encryptedFilename));
        double[][] original = BiGramStatistics.getBiGramStat(PathBuilder.get(dictionaryFilename));
        double bestDistance = Double.MAX_VALUE;
        char[] bestChars = null;
        System.out.println("\nAnalyze");
        for (int i = COUNT_TRY_FIND; i > 0; i--) {
            char[] chars = CHARS_ARRAY.clone();
            double probeDistance = BiGramStatistics.getCharsByRandomSwapper(chars, matrix, original);
            if (probeDistance < bestDistance) {
                i += COUNT_TRY_FIND;
                bestDistance = probeDistance;
                bestChars = chars.clone();
                //For debug only, here System.out.println - not the best solution. Here need the logger
                System.out.println("Best distance = " + bestDistance);
            }
        }
        return getCharacterList(bestChars);
    }

    private static List<Character> getCharacterList(char[] chars) {
        return String.valueOf(chars)
                .chars()
                .mapToObj(c -> (char) c)
                .toList();
    }
}
