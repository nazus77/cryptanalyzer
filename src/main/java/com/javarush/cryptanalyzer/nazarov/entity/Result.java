package com.javarush.cryptanalyzer.nazarov.entity;

public class Result {

    private final ResultCode resultCode;

    public Result(ResultCode resultCode) {
        this.resultCode = resultCode;
    }


    public ResultCode getResultCode() {
        return resultCode;
    }

    @Override
    public String toString() {
        return "Result: " + resultCode;
    }
}