package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.ALPHABET;

public class BruteForceAnalyzer implements Action {

    @Override
    public Result execute(String[] parameters) {

        String encodedFile = parameters[0], decodedFile = parameters[1], valueOfKey = parameters[2];

        List<String> list;

        try {
            list = Files.readAllLines(Path.of(encodedFile));
        } catch (IOException e) {
            throw new AppException(e.getMessage());
        }

        for (String s : list) {
            System.out.println(s);
        }



        return null;
    }
}

