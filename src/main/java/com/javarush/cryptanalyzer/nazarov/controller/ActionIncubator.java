package com.javarush.cryptanalyzer.nazarov.controller;

import com.javarush.cryptanalyzer.nazarov.service.Action;
import com.javarush.cryptanalyzer.nazarov.service.Decoder;
import com.javarush.cryptanalyzer.nazarov.service.Encoder;

public enum ActionIncubator {

    ENCODE(new Encoder()),
    DECODE(new Decoder());

    // поле для имплементаций интерфейса Action + кастомный конструктор
    private final Action action;

    ActionIncubator(Action action) {
        this.action = action;
    }

    public Action getActionIncubatorValue() {
        return action;
    }
}
