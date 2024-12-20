package ru.home.sevice.processor.base;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;

public interface UpdateProcessor {

    BotApiMethod<? extends Serializable> process(Update update);

    /**
     * Метод должен однозначно определить подходит ли наследник для обработки ивента
     */
    boolean identify(Update update);


}
