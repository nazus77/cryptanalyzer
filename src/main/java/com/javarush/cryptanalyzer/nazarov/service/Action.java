package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;
import com.javarush.cryptanalyzer.nazarov.entity.ResultCode;
import com.javarush.cryptanalyzer.nazarov.exception.AppException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.CHARS_ARRAY;
import static com.javarush.cryptanalyzer.nazarov.constants.CryptoAlphabet.CHARS_MAP;
import static com.javarush.cryptanalyzer.nazarov.constants.StatusConstants.ENCODER_ERROR;

public interface Action {

    Result execute(String[] parameters);

    default Result rotateAndCopy(String sourcePath, String targetPath, int key) {

        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath, StandardCharsets.UTF_8));
            BufferedWriter writer = new BufferedWriter(new FileWriter(targetPath, StandardCharsets.UTF_8)))
        {
            int charInt, length = CHARS_ARRAY.length;
            while ((charInt = reader.read()) > -1) {    // метод .read() считывает 1 чар и возвращает его инт (от 0 до 65 535)
                char character = (char) charInt;          // приводим этот инт в сам чар
                if (CHARS_MAP.containsKey(character)) {     // если в нашей мэпке есть такой чар
                    Integer currentIndex = CHARS_MAP.get(character); // то определяем его номер в мапе

                    int realKey = key % length < 0 ? length + key % length : key % length;
                    int newIndex = currentIndex + realKey >= length ? currentIndex - (length - realKey) : currentIndex + realKey;
                    // int newIndex = (currentIndex + key + Math.abs(key) * length) % length; // можно и так, но сложновато для понимания.

                    writer.write(CHARS_ARRAY[newIndex]);       // записываем в буферный массив чар с новым индексом.
                } else if (character == '\n') {              // при этом, спец.символ переноса строки переписываем без изменений.
                    writer.write(character);
                }
            }
        } catch (IOException e) {
            return new Result(ResultCode.ERROR);
        }
        return new Result(ResultCode.OK);
    }
}
