package ru.home.bot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.home.bot.variable.UpdateMessage;
import ru.home.config.BotProperties;
import ru.home.sevice.MessageResolver;

import java.util.List;

@Service
@ConditionalOnProperty(value = "bot.mock.enabled", havingValue = "false", matchIfMissing = true)
public class HealthBotImpl extends TelegramLongPollingBot implements HealthBot<UpdateMessage> {

    private final BotProperties botProperties;
    private final MessageResolver messageResolver;


    public HealthBotImpl(BotProperties botProperties, MessageResolver messageResolver) {
        super(botProperties.getToken());
        this.botProperties = botProperties;
        this.messageResolver = messageResolver;
    }

    @Override
    public void handleUpdate(UpdateMessage update) {
        onUpdateReceived(update);
    }

    /**
     * Диалог следующий:
     * кидаешь файл
     * он отправляет кнопки с текстом выберите тип посещения: "сдача анализов" "посещение врача" "операция" "манипуляции"
     * дальше кидает кнопки с алфавитом с вопросом "на какую букву начинается специальность врача?"
     * дальше кнопки по специальности
     * возможно стоит рассмотреть кнопку другое
     */

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(messageResolver.resolve(update));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return botProperties.getName();
    }


}

