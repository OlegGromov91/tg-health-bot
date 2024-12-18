package ru.home.sevice.processor.callback.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import ru.home.sevice.processor.base.MessageProvider;
import ru.home.sevice.processor.base.callback.CallBackProcessor;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import java.io.Serializable;

import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.DOCTORS_SPEC;


@Component
@RequiredArgsConstructor
public class ChoseDoctorSpecCallBackProcessor implements CallBackProcessor, MessageProvider {

    @Override
    public CallBackMapping.CallBackType callBackType() {
        return DOCTORS_SPEC;
    }

    @Override
    public EditMessageText processCallBack(CallbackQuery callback) {
        return buildEditMessageText(callback.getMessage().getChatId(), callback.getMessage().getMessageId(), "done");
    }

    @Override
    public BotApiMethod<? extends Serializable> processBackWayCallBack(CallbackQuery callback) {
        throw new UnsupportedOperationException();
    }


}
