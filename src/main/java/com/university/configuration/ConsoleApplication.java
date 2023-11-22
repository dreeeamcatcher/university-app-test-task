package com.university.configuration;

import com.university.exception.EntityNotFoundException;
import com.university.service.CommandHandler;
import com.university.service.DepartmentService;
import com.university.strategy.CommandStrategy;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsoleApplication implements CommandLineRunner {
    private final DepartmentService departmentService;
    private final CommandStrategy commandStrategy;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String initialString = generateInitialString();
        System.out.println(initialString);

        while (true) {
            System.out.println("Please, type your command: ");
            String command = scanner.nextLine();
            CommandHandler commandHandler = commandStrategy.getCommandHandler(command);
            try {
                commandHandler.parseCommand(command);
            } catch (EntityNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String generateInitialString() {
        String departments = departmentService.getDepartmentNames().toString();
        StringBuilder builder = new StringBuilder();
        builder.append("Hello! With this application you can perform following commands:")
                .append(System.lineSeparator())
                .append("1 - Find the head of department. ")
                .append("Command to use: 'Who is head of department {department_name}'")
                .append(System.lineSeparator())
                .append("2 - Check department statistics. ")
                .append("Command to use: 'Show {department_name} statistics'")
                .append(System.lineSeparator())
                .append("3 - Check the average salary for the department. ")
                .append("Command to use: ")
                .append("'Show the average salary for the department {department_name}'")
                .append(System.lineSeparator())
                .append("4 - Check the number of employees. ")
                .append("Command to use: 'Show count of employee for {department_name}'")
                .append(System.lineSeparator())
                .append("5 - Search lectors. ")
                .append("Command to use: 'Global search by {template}'")
                .append(System.lineSeparator())
                .append("Now we have the following departments: ")
                .append(departments)
                .append(System.lineSeparator());
        ;
        return builder.toString();
    }
}
