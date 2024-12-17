package ru.home.sevice.processor.callback.document;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.home.sevice.processor.base.MessageProvider;
import ru.home.sevice.processor.base.callback.CallBackProcessor;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.ALPHABET_DOCTORS_SPEC;
import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.CHOSE_MANIPULATION;
import static ru.home.sevice.processor.utils.MarkupGenerator.generateKeyboard;


@Component
public class StandardDocumentChoseManipulationCallBackProcessor implements CallBackProcessor, MessageProvider {

    private final InlineKeyboardMarkup keyboard = generateKeyboard(ALPHABET_DOCTORS_SPEC, 4);
    private final InlineKeyboardMarkup backKeyboard = generateKeyboard(CHOSE_MANIPULATION, 2);

    @Override
    public CallBackMapping.CallBackType callBackType() {
        return CHOSE_MANIPULATION;
    }

    @Override
    public EditMessageReplyMarkup processCallBack(CallbackQuery callback) {
        if (isNeedBackWay(callback)) {
            return buildEditMessage(callback.getMessage().getChatId(), callback.getMessage().getMessageId(), backKeyboard);
        }
        return buildEditMessage(callback.getMessage().getChatId(), callback.getMessage().getMessageId(), keyboard);
    }


}
