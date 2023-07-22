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
import java.util.ArrayList;
import java.util.List;

import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.ALPHABET;

public class Encoder implements Action {

    @Override
    public Result execute(String[] parameters) {

        String inputFile = parameters[0];
        String encodedFile = parameters[1];
        String valueOfKey = parameters[2];
        int key = Integer.parseInt(valueOfKey);

        //==============================================================================================================

        String tempString;
        List<Character> encodedCharsList = new ArrayList<>();

        List<String> strings;

//        StringBuilder sb = new StringBuilder();
//        try {
//            strings = Files.readAllLines(Path.of(inputFile));   // раскидали текст на строки
//            for (int i = 0; i < strings.size(); i++) {
//                tempString = strings.get(i);
//                for (int j = 0; j < tempString.length(); j++) {
//                    if (ALPHABET.indexOf(tempString.charAt(j)) != -1) { // если буква найдена в алфавите, то
////                        encodedCharsList.add(ALPHABET.indexOf(tempString.charAt(j)) ;
//                        System.out.print(ALPHABET.indexOf(tempString.charAt(j)));
//                    }
//                }
//            }
//        } catch (IOException e) {
//            throw new AppException(e);
//        }


//        String[] stringsArray = strings.toArray(new String[strings.size()]);
//
//        int position;
//        int newPosition;
//        StringBuilder stringBuilder = new StringBuilder();
//
//        for (int i = 0; i < stringsArray.length; i++) {
//                tempString = stringsArray[i];
//            for (int j = 0; j < tempString.length(); j++) {
//                if (ALPHABET.indexOf(tempString.charAt(j)) != -1) {
//                    position = ALPHABET.indexOf(tempString.charAt(j));
//                    newPosition = tempString.charAt(j + intKey);
//                    stringBuilder.append(ALPHABET.indexOf(newPosition));
//                } else {
//                    position = ALPHABET.indexOf(tempString.charAt(j));//неверно
//                    stringBuilder.append(ALPHABET.indexOf(position));
//                }
//            }
//        }
//        String encodedString = stringBuilder.toString();
//        System.out.println(encodedString);

        // System.out.println(strings(0));  // и почему стрингс нулевое на отвечает??? как тогда обратиться к первому элементу листа???
        // почему фор работает а фори нет???


//        for (int i = 0; i < strings.size(); i++) {
//            if (char)
//
//
//        }


//        try (Reader reader = new FileReader(inputFile);
//             Writer writer = new FileWriter(encodedFile) {

//            char oldSymbol, newSymbol;
//
//            while (reader.ready()) {
//                for (int i = 0; i < ALPHABET.length(); i++) {
//                    oldSymbol = (char) reader.read() == ALPHABET.charAt(i); // метод читает посимвольно
//                    newSymbol = ALPHABET.charAt(i + key);
//                }
//            }

        /*
        Энкодер использует все 3 параметра.
        использовать все пути можем сразу.
        сначала получаем каждый чар из потока ридера.
        открываем поток чтения и поток записи, кидаем туда соответствующие пути. каждый чар сопоставляем с таблицей и
        записываем в выходящий поток символ с таблица + 3 знака к примеру.
        Если символа нет, то переписываем его без смещения.

        декод - обратно.

         */

//        Path path = Path.of(PathFinder.getRoot() + txtFile); //
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

        return new

                Result(ResultCode.OK, "File encoded (encoded.txt)");

    }

}
