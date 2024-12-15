package ru.home.sevice.processor.base.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

@RequiredArgsConstructor
@Getter
public enum Buttons {

    TESTS(InlineKeyboardButton.builder().text("Сдача анализов").callbackData(CallBackType.CHOSE_MANIPULATION.name()).build(), CallBackType.CHOSE_MANIPULATION),
    VISITING_DOCTOR(InlineKeyboardButton.builder().text("Посещение врача").callbackData(CallBackType.CHOSE_MANIPULATION.name()).build(), CallBackType.CHOSE_MANIPULATION),
    OPERATION(InlineKeyboardButton.builder().text("Операция").callbackData(CallBackType.CHOSE_MANIPULATION.name()).build(), CallBackType.CHOSE_MANIPULATION),
    MANIPULATION(InlineKeyboardButton.builder().text("Манипуляция").callbackData(CallBackType.CHOSE_MANIPULATION.name()).build(), CallBackType.CHOSE_MANIPULATION),
    ;

    private final InlineKeyboardButton button;
    private final CallBackType type;


}
