package ru.home.sevice.processor.base.message.document;


import org.springframework.http.MediaType;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.home.sevice.processor.base.MessageProcessor;

import java.util.Set;

public interface DocumentMessageProcessor extends MessageProcessor {

    /**
     * Метод должен однозначно определить подходит ли наследник для обработки сообщения с типом Message
     */
    default boolean canProcessMessage(Message message) {
        return message.hasDocument() && canProcessDocument(message.getDocument());
    }

    boolean canProcessDocument(Document document);

}
