package com.university.service.impl;

import com.university.service.CommandHandler;
import com.university.service.LectorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GlobalSearchCommandImpl implements CommandHandler {
    private static final String REGEX_PATTERN = "Global search by (.+)$";
    private static final Pattern PATTERN = Pattern.compile(REGEX_PATTERN);
    private final LectorService lectorService;

    @Override
    public void parseCommand(String command) {
        Matcher matcher = PATTERN.matcher(command);
        matcher.find();
        String searchValue = matcher.group(1);
        String allBySearchValue = lectorService.findAllBySearchValue(searchValue);
        System.out.println(allBySearchValue);
    }

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }
}
