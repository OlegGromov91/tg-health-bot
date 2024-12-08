package ru.home;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.home.bot.HealthBotImpl;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class}, scanBasePackages = "ru.home")
@EntityScan(basePackages = {"ru.home"})
public class HealthApplication implements CommandLineRunner {

    private final HealthBotImpl healthBot;

    public HealthApplication(HealthBotImpl healthBot) {
        this.healthBot = healthBot;
    }

    public static void main(String[] args) {
        SpringApplication.run(HealthApplication.class, args);

    }

    @Override
    public void run(String... args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(healthBot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
