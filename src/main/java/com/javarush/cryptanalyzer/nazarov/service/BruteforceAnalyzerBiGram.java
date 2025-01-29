package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.utils.PathBuilder;
import com.javarush.cryptanalyzer.nazarov.utils.BiGramStatistics;
import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.CHARS_ARRAY;


public class BruteforceAnalyzerBiGram implements Action {

    @Override
    public Result execute(String[] parameters) {
        String encryptedFileName = parameters[0];
        String decryptedFileName = parameters[1];
        int bestKey = 0;
        double bestDestination = Double.MAX_VALUE;
        double[][] standardStat = BiGramStatistics.getBiGramStat(PathBuilder.get("dict.txt")); // захардкожено! исправить
        double[][] encryptedStat = BiGramStatistics.getBiGramStat(PathBuilder.get(encryptedFileName));

        for (int key = CHARS_ARRAY.length; key >= 0; key--) {
            double destination = BiGramStatistics.calcDistance(encryptedStat, standardStat);
            if (destination < bestDestination) {
                bestDestination = destination;
                bestKey = key;
            }
            BiGramStatistics.rotate(encryptedStat);
        }
        return rotateAndCopy(encryptedFileName, decryptedFileName, bestKey);
    }
}
