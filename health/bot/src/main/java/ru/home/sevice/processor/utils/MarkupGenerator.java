package ru.home.sevice.processor.utils;

import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.home.sevice.processor.base.common.Buttons;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class MarkupGenerator {

    public static InlineKeyboardMarkup generateTwoRawButtons(CallBackMapping.CallBackType callBackType) {
        List<InlineKeyboardButton> buttons = Arrays.stream(Buttons.values())
                .filter(button -> button.getType() == callBackType)
                .map(Buttons::getButton)
                .toList();
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

}
