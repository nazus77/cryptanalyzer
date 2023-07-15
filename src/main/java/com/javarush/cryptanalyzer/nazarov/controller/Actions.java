package com.javarush.cryptanalyzer.nazarov.controller;
import com.javarush.cryptanalyzer.nazarov.service.Action;
import com.javarush.cryptanalyzer.nazarov.service.Decoder;
import com.javarush.cryptanalyzer.nazarov.service.Encoder;

public enum Actions {

    // этот enum - контейнер (фабрика) команд
    // (правильнее использовать Map. Можно также использовать аннотации)

    ENCODE(new Encoder()),
    DECODE(new Decoder());

    // в этом энаме есть все объекты типа Actions,
    // порождающие соответствующие объекты из классов-сервисов.

    // среди полей есть также Action
    private final Action action;
    // имеем в виду имплементировавших Action


    Actions(Action action) {
        this.action = action;
    }
    // конструктор энама принимает одну из имплементаций Action


    public static Action find(String command) {
        return Actions.valueOf(command.toUpperCase()).action;
        // у Энама есть спец.метод valueOf для определения, что за объект
        // в конце .action - это для того, чтобы получить экземпляр самого ЭНАМА
    }
}
