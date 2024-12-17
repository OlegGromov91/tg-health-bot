package ru.home.sevice.processor.base.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

@RequiredArgsConstructor
@Getter
public enum Buttons {

    TESTS(InlineKeyboardButton.builder().text(CallBackMapping.TESTS.getData()).callbackData(CallBackMapping.TESTS.name()).build(), CallBackMapping.CallBackType.CHOSE_MANIPULATION),
    VISITING_DOCTOR(InlineKeyboardButton.builder().text(CallBackMapping.VISITING_DOCTOR.getData()).callbackData(CallBackMapping.VISITING_DOCTOR.name()).build(), CallBackMapping.CallBackType.CHOSE_MANIPULATION),
    OPERATION(InlineKeyboardButton.builder().text(CallBackMapping.OPERATION.getData()).callbackData(CallBackMapping.OPERATION.name()).build(), CallBackMapping.CallBackType.CHOSE_MANIPULATION),
    MANIPULATION(InlineKeyboardButton.builder().text(CallBackMapping.MANIPULATION.getData()).callbackData(CallBackMapping.MANIPULATION.name()).build(), CallBackMapping.CallBackType.CHOSE_MANIPULATION),

    A(InlineKeyboardButton.builder().text(CallBackMapping.ALPHABET_DOCTORS_SPEC_A.getData()).callbackData(CallBackMapping.ALPHABET_DOCTORS_SPEC_A.name()).build(), CallBackMapping.CallBackType.ALPHABET_DOCTORS_SPEC),
    B(InlineKeyboardButton.builder().text(CallBackMapping.ALPHABET_DOCTORS_SPEC_B.getData()).callbackData(CallBackMapping.ALPHABET_DOCTORS_SPEC_B.name()).build(), CallBackMapping.CallBackType.ALPHABET_DOCTORS_SPEC),
    ;

    private final InlineKeyboardButton button;
    private final CallBackMapping.CallBackType type;


}
