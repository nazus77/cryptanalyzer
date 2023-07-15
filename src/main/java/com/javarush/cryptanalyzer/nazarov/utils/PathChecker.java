package com.javarush.cryptanalyzer.nazarov.utils;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathChecker {

    public static boolean fileExistsCheck(String path) {
        return Files.isRegularFile(Path.of(path));
    }

    public static boolean fileTxtExtensionCheck(String path) {
        return path.endsWith(".txt");
    }

    public static boolean absolutePathCheck(String path) {
        return Path.of(path).isAbsolute();
    }

    public static boolean directoryExistsCheck(String path) {
        return Files.isDirectory(Path.of(path));
    }
}
