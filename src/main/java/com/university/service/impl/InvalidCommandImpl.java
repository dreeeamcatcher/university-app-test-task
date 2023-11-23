package com.university.service.impl;

import com.university.service.CommandHandler;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class InvalidCommandImpl implements CommandHandler {
    private static final String REGEX_PATTERN = "";
    private static final Pattern PATTERN = Pattern.compile(REGEX_PATTERN);

    @Override
    public void processCommand(String command) {
        System.out.println("Invalid command. Please, check the command templates and try again. "
                + "For exit type 'exit'");
    }

    @Override
    public Pattern getPattern() {
        return null;
    }
}
