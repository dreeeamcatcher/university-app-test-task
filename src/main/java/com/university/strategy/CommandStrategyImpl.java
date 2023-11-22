package com.university.strategy;

import com.university.service.CommandHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandStrategyImpl implements CommandStrategy {
    private final Map<Pattern, CommandHandler> commandHandlerMap = new HashMap<>();

    @Autowired
    public CommandStrategyImpl(List<CommandHandler> commandHandlers) {
        for (CommandHandler commandHandler : commandHandlers) {
            commandHandlerMap.put(commandHandler.getPattern(), commandHandler);
        }
    }

    @Override
    public CommandHandler getCommandHandler(String command) {
        for (Map.Entry<Pattern, CommandHandler> entry : commandHandlerMap.entrySet()) {
            if (entry.getKey() != null && entry.getKey().matcher(command).matches()) {
                return entry.getValue();
            }
        }
        return commandHandlerMap.get(null);
    }
}
