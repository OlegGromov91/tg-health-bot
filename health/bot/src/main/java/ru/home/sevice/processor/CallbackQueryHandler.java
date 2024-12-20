package ru.home.sevice.processor;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.MaybeInaccessibleMessage;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Optional;

public interface CallbackQueryHandler {

    default Long extractChatIdFromCallbackQuery(CallbackQuery callbackQuery) {
        return Optional.ofNullable(callbackQuery.getMessage())
                .map(MaybeInaccessibleMessage::getChatId)
                .orElseThrow(() -> new RuntimeException("Не найден chatId в callbackQuery"));
    }

    default Integer extractMessageIdFromCallbackQuery(CallbackQuery callbackQuery) {
        return Optional.ofNullable(callbackQuery.getMessage())
                .map(MaybeInaccessibleMessage::getMessageId)
                .orElseThrow(() -> new RuntimeException("Не найден messageId в callbackQuery"));
    }

    default Long extractUserIdFromCallbackQuery(CallbackQuery callbackQuery) {
        return Optional.ofNullable(callbackQuery.getFrom())
                .map(User::getId)
                .orElseThrow(() -> new RuntimeException("Не найден userId в callbackQuery"));
    }

    default EditMessageText.EditMessageTextBuilder getPreFilledCallbackMessage(CallbackQuery callbackQuery) {
        return EditMessageText.builder()
                .chatId(extractChatIdFromCallbackQuery(callbackQuery))
                .messageId(extractMessageIdFromCallbackQuery(callbackQuery));
    }
}
