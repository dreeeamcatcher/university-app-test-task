package com.university.service;

import com.university.exception.EntityNotFoundException;
import java.util.regex.Pattern;

public interface CommandHandler {
    void parseCommand(String command) throws EntityNotFoundException;

    Pattern getPattern();
}
