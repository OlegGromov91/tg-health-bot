package ru.home.sevice.processor.base.callback;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.home.sevice.processor.base.UpdateProcessor;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import java.io.Serializable;
import java.util.Optional;

public interface CallBackProcessor extends UpdateProcessor {

    default BotApiMethod<? extends Serializable> process(Update update) {
        return (isNeedBackWay(update.getCallbackQuery())) ? processBackWayCallBack(update.getCallbackQuery())
                : processCallBack(update.getCallbackQuery());
    }

    default boolean identify(Update update) {
        return Optional.ofNullable(update.getCallbackQuery())
                .map(CallbackQuery::getData)
                .map(data -> CallBackMapping.isCanProcessCallBack(data, callBackType()) || CallBackMapping.isBackWayCallBack(data, callBackType()))
                .orElse(false);
    }

    /**
     * Метод должен однозначно определить подходит ли наследник для обработки колбэка
     */
    CallBackMapping.CallBackType callBackType();

    BotApiMethod<? extends Serializable> processCallBack(CallbackQuery callback);

    BotApiMethod<? extends Serializable> processBackWayCallBack(CallbackQuery callback);

    default boolean isNeedBackWay(CallbackQuery callback) {
        return CallBackMapping.getCallBack(callback.getData())
                .map(CallBackMapping::isBackWayData)
                .orElse(false);
    }


}
