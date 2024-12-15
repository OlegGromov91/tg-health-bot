package ru.home.sevice.processor.base;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.home.sevice.processor.base.UpdateProcessor;

import java.util.function.Predicate;

public interface MessageProcessor extends UpdateProcessor {

    default boolean identify(Update update) {
        return update.hasMessage() && canProcessMessage(update.getMessage());
    }

    /**
     * Метод должен однозначно определить подходит ли наследник для обработки сообщения с типом Message
     */
    boolean canProcessMessage(Message message);


}
