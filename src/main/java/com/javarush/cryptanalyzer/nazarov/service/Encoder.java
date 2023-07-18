package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;
import com.javarush.cryptanalyzer.nazarov.utils.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        String txtFile = parameters[0];
        String encodedFile = parameters[1];





        Path path = Path.of(PathFinder.getRoot() + txtFile);

        try {
            List<String> strings = Files.readAllLines(path); // раскидали на строки текст, содержащийся в
            for (String string : strings) {
                System.out.println(string);
            }
        } catch (IOException e) {
            throw new AppException("IO Error ,", e);
        }

        return new Result(ResultCode.OK, "read all bytes " + path);

        //TODO дописать сюда логику чтения + кодирования и вывода
    }
}
