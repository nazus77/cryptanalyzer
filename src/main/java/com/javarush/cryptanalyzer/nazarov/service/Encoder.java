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
        String key = parameters[2]; // а вот как ключ валидировать, если у него совпадёт с нулём при остатке от деления...

        try {
            List<String> strings = Files.readAllLines(Path.of(inputFile)); // раскидали на строки текст
            for (String string : strings) {
                System.out.println(string);     // распечатываем весь файл
            }
        } catch (IOException e) {
            throw new AppException(e);
        }


//        try (Reader reader = new FileReader(inputFile);
//                Writer writer = new FileWriter(encodedFile) {
//
//            char oldSymbol, newSymbol;
//
//            while (reader.ready()) {
//                for (int i = 0; i < ALPHABET.length(); i++) {
//                    oldSymbol = (char) reader.read() == ALPHABET.charAt(i); // метод читает посимвольно
//                    newSymbol = ALPHABET.charAt(i + key);
//
//                }
//
//            }
//
//        } catch (FileNotFoundException fileNotFoundException) {
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } ;
//            throw new AppException(e);
//        {
//


        /*
        сначала переписываем алфавит как у Саши. из стринга легко в тучарэррэй сделать, так что не переживай.

        Энкодер использует все 3 параметра.
        первый путь надо проверить, либо это инпут тхт, тогда сразу можем его использовать.
        если что-то другое, то используем сразу его.

        то есть использовать путь можем сразу!!! Проверить это

        второй путь может прийти либо по-умолчанию либо работающий текст тхт, тоже можем сразу использовать.

        открываем поток чтения и поток записи, кидаем туда соответствующие пути. каждый чар сопоставляем с таблицей и
        записываем в выходящий поток символ с таблица + 3 знака к примеру.
        Если символа нет, то переписываем его без смещения.

        декод - обратно.

         */

//        Path path = Path.of(PathFinder.getRoot() + txtFile); // а вот эту прибамбасину куда и как деть? как использовать?
//
//
//        try {
//            List<String> strings = Files.readAllLines(path); // раскидали на строки текст, содержащийся в
//            for (String string : strings) {
//                System.out.println(string);
//            }
//        } catch (IOException e) {
//            throw new AppException("IO Error ,", e);
//        }

        return new Result(ResultCode.OK, "File encoded (encoded.txt)");

    }
}
