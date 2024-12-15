package ru.home.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.home.sevice.processor.base.MessageProcessor;

import java.io.Serializable;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MessageResolver {

    private final Set<MessageProcessor> processors;


    public BotApiMethod<? extends Serializable> resolve(Update update) {
        MessageProcessor messageProcessor = findResolver(update);
        return messageProcessor.process(update);
    }

    private MessageProcessor findResolver(Update update) {
        return processors.stream()
                .filter(resolver -> resolver.identify(update))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can not find resolver"));
    }


}
