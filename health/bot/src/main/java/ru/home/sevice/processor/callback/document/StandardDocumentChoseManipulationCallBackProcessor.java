package ru.home.sevice.processor.callback.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.home.sevice.processor.base.MessageProvider;
import ru.home.sevice.processor.base.callback.CallBackProcessor;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import java.io.Serializable;

import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.CHOSE_MANIPULATION;


@Component
@RequiredArgsConstructor
public class StandardDocumentChoseManipulationCallBackProcessor implements CallBackProcessor, MessageProvider {

    private final InlineKeyboardMarkup alphabetDoctorsSpecKeyboard;
    private final InlineKeyboardMarkup choseManipulationKeyboard;

    @Override
    public CallBackMapping.CallBackType callBackType() {
        return CHOSE_MANIPULATION;
    }

    @Override
    public EditMessageReplyMarkup processCallBack(CallbackQuery callback) {
        return buildEditMessage(callback.getMessage().getChatId(), callback.getMessage().getMessageId(), alphabetDoctorsSpecKeyboard);
    }

    @Override
    public BotApiMethod<? extends Serializable> processBackWayCallBack(CallbackQuery callback) {
        return buildEditMessage(callback.getMessage().getChatId(), callback.getMessage().getMessageId(), choseManipulationKeyboard);
    }


}
