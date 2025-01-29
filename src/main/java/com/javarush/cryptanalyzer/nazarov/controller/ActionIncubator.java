package com.javarush.cryptanalyzer.nazarov.controller;

import com.javarush.cryptanalyzer.nazarov.service.*;


public enum ActionIncubator {

    ENCODER(new Encoder()),
    DECODER(new Decoder()),
    BRUTEFORCE_ANALYZER(new BruteForceAnalyzer()),
    STATISTICAL_ANALYZER(new StatisticalAnalyzer());

    private final Action action;

    ActionIncubator(Action action) {
        this.action = action;
    }

    public Action getActionIncubatorValue() {
        return action;
    }
}
