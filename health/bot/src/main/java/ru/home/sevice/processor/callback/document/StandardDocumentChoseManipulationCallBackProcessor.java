package ru.home.sevice.processor.callback.document;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.home.sevice.processor.base.MessageProvider;
import ru.home.sevice.processor.base.callback.CallBackProcessor;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.CHOSE_MANIPULATION;
import static ru.home.sevice.processor.utils.MarkupGenerator.generateTwoRawButtons;


@Component
public class StandardDocumentChoseManipulationCallBackProcessor implements CallBackProcessor, MessageProvider {

    private final InlineKeyboardMarkup keyboard = generateTwoRawButtons(CallBackMapping.CallBackType.ALPHABET_DOCTORS_SPEC);

    @Override
    public CallBackMapping.CallBackType callBackType() {
        return CHOSE_MANIPULATION;
    }

    @Override
    public EditMessageReplyMarkup processCallBack(CallbackQuery callback) {
        //todo
        return buildEditMessage(callback.getMessage().getChatId(), callback.getMessage().getMessageId(), keyboard);
    }


}
