package ru.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.home.sevice.processor.base.common.callback.CallBackMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.*;
import static ru.home.sevice.processor.utils.MarkupGenerator.generateKeyboard;

@Configuration
public class BotBeanPartsConfig {

    @Bean
    public InlineKeyboardMarkup alphabetDoctorsSpecKeyboard() {
        return generateKeyboard(ALPHABET_DOCTORS_SPEC, 4);
    }

    @Bean
    public InlineKeyboardMarkup choseManipulationKeyboard() {
        return generateKeyboard(CHOSE_MANIPULATION, 2);
    }

    @Bean
    public Map<String, InlineKeyboardMarkup> alphabetWithDoctorsSpecButtonMapping() {
        Map<String, InlineKeyboardMarkup> alphabetWithDoctorsSpecButtonMapping = new HashMap<>();
        Arrays.stream(CallBackMapping.values())
                .filter(mapping -> mapping.getCallBackType() == ALPHABET_DOCTORS_SPEC)
                .filter(CallBackMapping::isNotBackWayData)
                .forEach(alphabetCallBackType -> {
            String template = alphabetCallBackType.name().substring(0, 2).concat(DOCTORS_SPEC.name());
            InlineKeyboardMarkup keyboard = generateKeyboard(DOCTORS_SPEC, 2,
                    button -> button.getCallbackData().startsWith(template) | button.getText().equals(CallBackMapping.BACK_CALL_BACK_DATA));
            alphabetWithDoctorsSpecButtonMapping.put(alphabetCallBackType.name(), keyboard);
        });
        return alphabetWithDoctorsSpecButtonMapping;
    }

}
