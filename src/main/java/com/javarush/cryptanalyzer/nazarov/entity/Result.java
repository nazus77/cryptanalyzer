package com.javarush.cryptanalyzer.nazarov.entity;

public class Result {

    private final ResultCode resultCode;
    // создали это поле, чтобы когда возвращали объект резалта
    // записывали ок или не ок все выполнилось
    private final String message;
    // создали это поле, чтобы когда возвращали объект резалта
    // записывали какое-то сообщение: допустим с адресом закодированного файла


    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                '}';
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    public Result(ResultCode resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
