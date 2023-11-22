package com.university.strategy;

import com.university.service.CommandHandler;

public interface CommandStrategy {
    CommandHandler getCommandHandler(String command);
}
