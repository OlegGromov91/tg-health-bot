package ru.home.sevice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.home.sevice.processor.base.MessageProcessor;
import ru.home.sevice.processor.base.UpdateProcessor;

import java.io.Serializable;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MessageResolver {

    private final Set<UpdateProcessor> processors;


    public BotApiMethod<? extends Serializable> resolve(Update update) {
        UpdateProcessor processor = findResolver(update);
        return processor.process(update);
    }

    private UpdateProcessor findResolver(Update update) {
        return processors.stream()
                .filter(resolver -> resolver.identify(update))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can not find resolver"));
    }


}
