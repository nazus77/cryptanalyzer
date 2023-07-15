package com.javarush.cryptanalyzer.nazarov.service;

import com.javarush.cryptanalyzer.nazarov.entity.Result;

public interface Action {

    Result execute(String[] parameters);

}
