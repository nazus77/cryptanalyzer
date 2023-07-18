package com.javarush.cryptanalyzer.nazarov.controller;

import com.javarush.cryptanalyzer.nazarov.service.Action;
import com.javarush.cryptanalyzer.nazarov.service.Decoder;
import com.javarush.cryptanalyzer.nazarov.service.Encoder;

public enum ActionIncubator {

    // Энамовский класс - фабрика команд.
    // Более верно - использовать Map.
    // Можно также использовать аннотации

    ENCODE(new Encoder()),
    DECODE(new Decoder());

    // добавляем поле для имплементаций Action и кастомный конструктор.
    private final Action action;

    ActionIncubator(Action action) {
        this.action = action;
    }

    public Action getActionIncubatorValue() {
        return action;
    }
}
