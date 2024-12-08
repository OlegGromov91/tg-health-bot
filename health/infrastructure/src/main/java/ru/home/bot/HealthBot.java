package ru.home.bot;

import ru.home.bot.variable.BotUpdate;

public interface HealthBot<U extends BotUpdate> {

    void handleUpdate(U update);


}
