package com.university.service.impl;

import com.university.service.CommandHandler;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExitCommandImpl implements CommandHandler {
    private static final String REGEX_PATTERN = "exit";
    private static final Pattern PATTERN = Pattern.compile(REGEX_PATTERN);

    @Override
    public void processCommand(String command) {
        System.out.println("Exiting application.");
        System.exit(0);
    }

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }
}
