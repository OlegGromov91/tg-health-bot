package ru.home.sevice.processor.callback.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.home.sevice.processor.base.MessageProvider;
import ru.home.sevice.processor.base.callback.CallBackProcessor;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.CHOSE_MANIPULATION;
import static ru.home.sevice.processor.base.common.callback.CallBackTextMessages.CHOSE_ALPHABET_DOCTORS_SPEC_TEXT;
import static ru.home.sevice.processor.base.common.callback.CallBackTextMessages.CHOSE_MANIPULATION_TEXT;


@Component
@RequiredArgsConstructor
public class ChoseManipulationCallBackProcessor implements CallBackProcessor, MessageProvider {

    private final InlineKeyboardMarkup alphabetDoctorsSpecKeyboard;
    private final InlineKeyboardMarkup choseManipulationKeyboard;

    @Override
    public CallBackMapping.CallBackType callBackType() {
        return CHOSE_MANIPULATION;
    }

    @Override
    public EditMessageText processCallBack(CallbackQuery callback) {
        return buildEditMessageText(callback.getMessage().getChatId(), callback.getMessage().getMessageId(),
                alphabetDoctorsSpecKeyboard, CHOSE_ALPHABET_DOCTORS_SPEC_TEXT);
    }

    @Override
    public EditMessageText processBackWayCallBack(CallbackQuery callback) {
        return buildEditMessageText(callback.getMessage().getChatId(), callback.getMessage().getMessageId(),
                choseManipulationKeyboard, CHOSE_MANIPULATION_TEXT);
    }


}
