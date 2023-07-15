package com.javarush.cryptanalyzer.nazarov.utils;

import java.io.File;

public class PathFinder {
    public static String getRoot() {
        String root = System.getProperty("user.dir");

        return root + File.separator + "text" + File.separator;
        // файл сепаратор - это разделитель в зависимости от системы!
    }
}
