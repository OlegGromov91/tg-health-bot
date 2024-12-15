package ru.home.sevice.processor.message.document;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.home.sevice.processor.base.Markupable;
import ru.home.sevice.processor.base.common.CallBackType;
import ru.home.sevice.processor.base.message.document.DocumentMessageProcessor;
import ru.home.sevice.processor.utils.TgMimeTypes;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StandardDocumentMessageProcessor implements DocumentMessageProcessor, Markupable {

    private static final Set<String> STANDARD_AVAILABLE_DOCUMENT_TYPE = Arrays.stream(TgMimeTypes.values())
            .filter(type -> type.getAppType() == TgMimeTypes.AppMediaType.STANDARD_DOCUMENT)
            .map(TgMimeTypes::getMimeType)
            .collect(Collectors.toSet());

    private final InlineKeyboardMarkup inlineKeyboardMarkup = generateTwoRawButtons();


    @Override
    public boolean canProcessDocument(Document document) {
        return STANDARD_AVAILABLE_DOCUMENT_TYPE.contains(document.getMimeType());
    }

    @Override
    public SendMessage processDocument(Document document, String additionalText, Long chatId) {
        return buildMessage(chatId, "Выберите тип посещения", inlineKeyboardMarkup);
    }

    @Override
    public CallBackType getMarkupType() {
        return CallBackType.CHOSE_MANIPULATION;
    }

}
