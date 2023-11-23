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
public class GetAverageSalaryCommandImpl implements CommandHandler {
    private static final String REGEX_PATTERN = "Show the average salary for the department (.+)$";
    private static final Pattern PATTERN = Pattern.compile(REGEX_PATTERN);
    private final DepartmentService departmentService;

    @Override
    public void processCommand(String command) throws EntityNotFoundException {
        Matcher matcher = PATTERN.matcher(command);
        matcher.find();
        String departmentName = matcher.group(1);
        Double averageSalary = departmentService.getAverageSalaryOfDepartment(departmentName);
        System.out.println("The average salary of " + departmentName
                + " department is " + averageSalary);
    }

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }
}
