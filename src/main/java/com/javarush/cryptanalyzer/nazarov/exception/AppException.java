package com.javarush.cryptanalyzer.nazarov.exception;

public class AppException extends RuntimeException {

    public AppException() {
    }
    public AppException(String message) {
        super(message);
    }
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
    public AppException(Throwable cause) {
        super(cause);
    }
}
