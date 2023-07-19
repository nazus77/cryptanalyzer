package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;
import com.javarush.cryptanalyzer.nazarov.utils.PathFinder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.ALPHABET;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        String inputFile = parameters[0];
        String encodedFile = parameters[1];
        String key = parameters[2];


        return new Result(ResultCode.OK, "File encoded (encoded.txt)");

    }
}
