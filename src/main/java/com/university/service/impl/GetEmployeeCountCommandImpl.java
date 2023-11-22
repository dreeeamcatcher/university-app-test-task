package com.university.service.impl;

import com.university.exception.EntityNotFoundException;
import com.university.service.CommandHandler;
import com.university.service.DepartmentService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetEmployeeCountCommandImpl implements CommandHandler {
    private static final String REGEX_PATTERN = "Show count of employee for (.+)$";
    private static final Pattern PATTERN = Pattern.compile(REGEX_PATTERN);
    private final DepartmentService departmentService;

    @Override
    public void parseCommand(String command) throws EntityNotFoundException {
        Matcher matcher = PATTERN.matcher(command);
        matcher.find();
        String departmentName = matcher.group(1);
        int employeesCount = departmentService.countEmployeesForDepartment(departmentName);
        System.out.println(employeesCount);
    }

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }
}
