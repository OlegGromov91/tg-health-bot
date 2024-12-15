package ru.home.sevice.processor.callback.document;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.home.sevice.processor.base.Markupable;
import ru.home.sevice.processor.base.MessageProvider;
import ru.home.sevice.processor.base.callback.CallBackProcessor;
import ru.home.sevice.processor.base.common.CallBackType;

@Component
public class StandardDocumentChoseManipulationCallBackProcessor implements CallBackProcessor, Markupable, MessageProvider {

    private final InlineKeyboardMarkup keyboard = generateTwoRawButtons();

    @Override
    public CallBackType callBackType() {
        return CallBackType.CHOSE_MANIPULATION;
    }

    @Override
    public EditMessageReplyMarkup processCallBack(CallbackQuery callback) {
        //todo
        return buildEditMessage(callback.getMessage().getChatId(), callback.getMessage().getMessageId(), keyboard);
    }

    @Override
    public CallBackType getMarkupType() {
        return CallBackType.CHOSE_ALPHABET_DOCTORS_SPEC;
    }
}
