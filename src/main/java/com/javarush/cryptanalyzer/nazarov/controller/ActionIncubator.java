package com.javarush.cryptanalyzer.nazarov.controller;

import com.javarush.cryptanalyzer.nazarov.service.*;

public enum ActionIncubator {

    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCEANALYSER(new BruteForceAnalyzer()),
    STATYSTICALANALYSER(new StatysticalAnalizer());

    // поле для имплементаций интерфейса Action + кастомный конструктор
    private final Action action;

    ActionIncubator(Action action) {
        this.action = action;
    }

    public Action getActionIncubatorValue() {
        return action;
    }
}
