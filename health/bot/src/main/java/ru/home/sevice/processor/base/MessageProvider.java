package ru.home.sevice.processor.base;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface MessageProvider {

    default SendMessage buildMessage(Long chatId, String message) {
        return SendMessage.builder()
                .chatId(chatId)
                .text(message)
                .build();
    }
}
