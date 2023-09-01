package com.javarush.cryptanalyzer.nazarov.controller;

import com.javarush.cryptanalyzer.nazarov.service.*;

public enum ActionIncubator {

    ENCODE(new Encoder()),
    DECODE(new Decoder()),
    BRUTEFORCEANALYZER(new BruteForceAnalyzer()),
    STATISTICALANALYZER(new StatisticalAnalyzer());

    private final Action action;

    ActionIncubator(Action action) {
        this.action = action;
    }

    public Action getActionIncubatorValue() {
        return action;
    }
}
