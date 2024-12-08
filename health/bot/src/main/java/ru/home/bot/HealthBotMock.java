package ru.home.bot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import ru.home.bot.variable.UpdateMessage;

@Service
@ConditionalOnProperty(value = "bot.mock.enabled", havingValue = "true", matchIfMissing = true)
public class HealthBotMock implements HealthBot<UpdateMessage> {

    public HealthBotMock() {
        System.out.println();
    }

    @Override
    public void handleUpdate(UpdateMessage update) {
        throw new IllegalArgumentException("Mock not available");
    }


}
