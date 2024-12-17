package ru.home.sevice.processor.utils;

import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import java.util.*;

@UtilityClass
public class MarkupGenerator {

    private static final Map<CallBackMapping.CallBackType, List<InlineKeyboardButton>> BUTTONS = initButtons();


    public static InlineKeyboardMarkup generateTwoRawButtons(CallBackMapping.CallBackType callBackType) {
        List<InlineKeyboardButton> buttons = Optional.ofNullable(BUTTONS.get(callBackType)).orElse(List.of());
        List<List<InlineKeyboardButton>> resultMatrixButton = new ArrayList<>((buttons.size() / 2) + 1);
        List<InlineKeyboardButton> twoButtons = new ArrayList<>(2);
        for (int i = 0; i < buttons.size(); i++) {
            if (i != 0 && i % 2 == 0) {
                resultMatrixButton.add(twoButtons);
                twoButtons = new ArrayList<>(2);
            }
            twoButtons.add(buttons.get(i));
            if (i == buttons.size() - 1) {
                resultMatrixButton.add(twoButtons);
            }
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

}
