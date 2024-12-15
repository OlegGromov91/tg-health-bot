package ru.home.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Configuration
@ConfigurationProperties(prefix = "bot")
public class BotProperties {

    private String name;
    private String token;
    private String fileInfo;
    private String fileStorage;

    public void setName(String name) {
        this.name = name;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setFileInfo(String fileInfo) {
        this.fileInfo = fileInfo;
    }

    public void setFileStorage(String fileStorage) {
        this.fileStorage = fileStorage;
    }
}
