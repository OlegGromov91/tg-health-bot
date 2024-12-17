package ru.home.sevice.processor.utils;

import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import java.util.*;

@UtilityClass
public class MarkupGenerator {

    private static final Map<CallBackMapping.CallBackType, List<InlineKeyboardButton>> BUTTONS = initButtons();

    public static InlineKeyboardMarkup generateKeyboard(CallBackMapping.CallBackType callBackType, int maxRawSize) {
        List<InlineKeyboardButton> allButtons = BUTTONS.getOrDefault(callBackType, List.of());

        List<InlineKeyboardButton> allButtonsWithoutBackButton = allButtons
                .stream()
                .filter(MarkupGenerator::isNotBackButtonText)
                .toList();

        InlineKeyboardButton backButton = allButtons
                .stream()
                .filter(MarkupGenerator::isBackButtonText)
                .findFirst()
                .orElse(null);

        List<List<InlineKeyboardButton>> resultMatrixButton = new ArrayList<>();
        List<InlineKeyboardButton> buttons = new ArrayList<>(maxRawSize);
        for (int i = 0; i < allButtonsWithoutBackButton.size(); i++) {
            if (i != 0 && i % maxRawSize == 0) {
                resultMatrixButton.add(buttons);
                buttons = new ArrayList<>(maxRawSize);
            }
            buttons.add(allButtonsWithoutBackButton.get(i));
            if (i == allButtonsWithoutBackButton.size() - 1) {
                resultMatrixButton.add(buttons);
            }
        }
        if (backButton != null) {
            resultMatrixButton.add(List.of(backButton));
        }
        return InlineKeyboardMarkup.builder()
                .keyboard(resultMatrixButton)
                .build();
    }


    private static Map<CallBackMapping.CallBackType, List<InlineKeyboardButton>> initButtons() {
        Map<CallBackMapping.CallBackType, List<InlineKeyboardButton>> buttons = new HashMap<>();
        Arrays.stream(CallBackMapping.values()).forEach(callBack ->
                buttons.compute(callBack.getCallBackType(), (type, buttonList) -> {
                    InlineKeyboardButton button = InlineKeyboardButton.builder()
                            .text(callBack.getData())
                            .callbackData(callBack.name())
                            .build();
                    if (buttonList == null) {
                        List<InlineKeyboardButton> newButtonList = new ArrayList<>();
                        newButtonList.add(button);
                        buttonList = newButtonList;
                    } else {
                        buttonList.add(button);
                    }
                    return buttonList;
                }));
        return buttons;
    }

    private boolean isNotBackButtonText(InlineKeyboardButton button) {
        return !CallBackMapping.BACK_CALL_BACK_DATA.equals(button.getText());
    }

    private boolean isBackButtonText(InlineKeyboardButton button) {
        return CallBackMapping.BACK_CALL_BACK_DATA.equals(button.getText());
    }
}
