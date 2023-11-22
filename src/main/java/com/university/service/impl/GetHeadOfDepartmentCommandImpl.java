package com.university.service.impl;

import com.university.exception.EntityNotFoundException;
import com.university.model.Lector;
import com.university.service.CommandHandler;
import com.university.service.DepartmentService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetHeadOfDepartmentCommandImpl implements CommandHandler {
    private static final String REGEX_PATTERN = "Who is head of department (.+)$";
    private static final Pattern PATTERN = Pattern.compile(REGEX_PATTERN);
    private final DepartmentService departmentService;

    @Override
    public void parseCommand(String command) throws EntityNotFoundException {
        Matcher matcher = PATTERN.matcher(command);
        matcher.find();
        String departmentName = matcher.group(1);
        Lector headOfDepartment = departmentService.getHeadOfDepartment(departmentName);
        System.out.println("Head of " + departmentName
                + " department is " + headOfDepartment.getName());
    }

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }
}
