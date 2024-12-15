package ru.home.sevice.processor.base.message.document;


import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.home.sevice.processor.base.MessageProcessor;
import ru.home.sevice.processor.utils.StringUtils;

import java.util.Optional;

public interface DocumentMessageProcessor extends MessageProcessor {

    @Override
    default SendMessage processMessage(Message message) {
        return processDocument(message.getDocument(),
                Optional.ofNullable(message.getCaption()).orElse(StringUtils.EMPTY_STRING),
                message.getChatId());
    }

    /**
     * Метод должен однозначно определить подходит ли наследник для обработки сообщения с типом Message
     */
    default boolean canProcessMessage(Message message) {
        return message.hasDocument() && canProcessDocument(message.getDocument());
    }

    boolean canProcessDocument(Document document);

    SendMessage processDocument(Document document, String additionalText, Long chatId);

}
