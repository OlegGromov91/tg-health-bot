package ru.home.sevice.processor.base;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface MessageProvider {

    default SendMessage buildMessage(Long chatId, String message) {
        return SendMessage.builder()
                .chatId(chatId)
                .text(message)
                .build();
    }

    default SendMessage buildMessage(Long chatId, String message, InlineKeyboardMarkup markup) {
        return SendMessage.builder()
                .chatId(chatId)
                .replyMarkup(markup)
                .text(message)
                .build();
    }

    default EditMessageReplyMarkup buildEditMessage(Long chatId, Integer messageId, InlineKeyboardMarkup markup) {
        return EditMessageReplyMarkup.builder()
                .chatId(chatId)
                .messageId(messageId)
                .replyMarkup(markup)
                .build();
    }
}
