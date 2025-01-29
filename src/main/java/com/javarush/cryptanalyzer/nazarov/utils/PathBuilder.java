package com.javarush.cryptanalyzer.nazarov.utils;

import java.io.File;
import java.nio.file.Path;


public class PathBuilder {

    private PathBuilder() {
    }

    public static Path get(String filename) {
        Path path = Path.of(filename);
        return path.isAbsolute() ? path : Path.of(System.getProperty("user.dir") + File.separator + "text" + File.separator + filename);
    }
}

