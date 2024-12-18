package ru.home.sevice.processor.callback.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.home.sevice.processor.base.MessageProvider;
import ru.home.sevice.processor.base.callback.CallBackProcessor;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import java.util.Map;

import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.ALPHABET_DOCTORS_SPEC;
import static ru.home.sevice.processor.base.common.callback.CallBackTextMessages.CHOSE_ALPHABET_DOCTORS_SPEC_TEXT;
import static ru.home.sevice.processor.base.common.callback.CallBackTextMessages.CHOSE_DOCTOR_SPEC_TEXT;


@Component
@RequiredArgsConstructor
public class ChoseAlpabetDoctorSpecCallBackProcessor implements CallBackProcessor, MessageProvider {

    private final Map<String, InlineKeyboardMarkup> alphabetWithDoctorsSpecButtonMapping;
    private final InlineKeyboardMarkup alphabetDoctorsSpecKeyboard;

    @Override
    public CallBackMapping.CallBackType callBackType() {
        return ALPHABET_DOCTORS_SPEC;
    }

    @Override
    public EditMessageText processCallBack(CallbackQuery callback) {
        return buildEditMessageText(callback.getMessage().getChatId(), callback.getMessage().getMessageId(),
                alphabetWithDoctorsSpecButtonMapping.get(callback.getData()), CHOSE_DOCTOR_SPEC_TEXT);
    }

    @Override
    public EditMessageText processBackWayCallBack(CallbackQuery callback) {
        return buildEditMessageText(callback.getMessage().getChatId(), callback.getMessage().getMessageId(),
                alphabetDoctorsSpecKeyboard, CHOSE_ALPHABET_DOCTORS_SPEC_TEXT);
    }


}
