package ru.home.sevice.processor.base;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;

public interface MessageProcessor extends UpdateProcessor, MessageProvider {

    default BotApiMethod<? extends Serializable> process(Update update) {
        return processMessage(update.getMessage());
    }

    default boolean identify(Update update) {
        return update.hasMessage() && canProcessMessage(update.getMessage());
    }

    /**
     * Метод должен однозначно определить подходит ли наследник для обработки сообщения с типом Message
     */
    boolean canProcessMessage(Message message);

    SendMessage processMessage(Message message);


}
