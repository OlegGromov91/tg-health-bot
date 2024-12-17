package ru.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.ALPHABET_DOCTORS_SPEC;
import static ru.home.sevice.processor.base.common.callback.CallBackMapping.CallBackType.CHOSE_MANIPULATION;
import static ru.home.sevice.processor.utils.MarkupGenerator.generateKeyboard;

@Configuration
public class BotPartsConfig {

    @Bean
    public InlineKeyboardMarkup alphabetDoctorsSpecKeyboard() {
        return generateKeyboard(ALPHABET_DOCTORS_SPEC, 4);
    }

    @Bean
    public InlineKeyboardMarkup choseManipulationKeyboard() {
        return generateKeyboard(CHOSE_MANIPULATION, 2);
    }

}
