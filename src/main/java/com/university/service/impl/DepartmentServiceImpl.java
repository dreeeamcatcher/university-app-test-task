package com.university.service.impl;

import com.university.exception.EntityNotFoundException;
import com.university.model.Degree;
import com.university.model.Department;
import com.university.model.Lector;
import com.university.repository.DepartmentRepository;
import com.university.service.DepartmentService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Lector getHeadOfDepartment(String departmentName) throws EntityNotFoundException {
        Department department =
                departmentRepository.findByName(departmentName).orElseThrow(() ->
                        new EntityNotFoundException("Can't find department by name = "
                                + departmentName));
        return department.getHeadOfDepartment();
    }

    @Override
    public List<String> getDepartmentNames() {
        return departmentRepository.findAll().stream().map(Department::getName).toList();
    }

    @Override
    public String getDepartmentStatistics(String departmentName) throws EntityNotFoundException {
        Department department =
                departmentRepository.findByNameWithEmployees(departmentName).orElseThrow(() ->
                        new EntityNotFoundException("Can't find department by name = "
                                + departmentName));
        Map<Degree, Long> departmentStats =
                department.getLectors().stream().collect(Collectors.groupingBy(Lector::getDegree,
                        Collectors.counting()));

        StringBuilder builder = new StringBuilder();
        for (Degree degree : Degree.values()) {
            builder.append(degree)
                    .append("S")
                    .append(" - ")
                    .append(departmentStats.get(degree))
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }

    @Override
    public Double getAverageSalaryOfDepartment(String departmentName)
            throws EntityNotFoundException {
        Department department =
                departmentRepository.findByNameWithEmployees(departmentName).orElseThrow(() ->
                        new EntityNotFoundException("Can't find department by name = "
                                + departmentName));
        return department.getLectors().stream()
                .mapToDouble(lector -> lector.getSalary().doubleValue())
                .average()
                .orElse(0);
    }

    @Override
    public int countEmployeesForDepartment(String departmentName) throws EntityNotFoundException {
        Department department =
                departmentRepository.findByNameWithEmployees(departmentName).orElseThrow(() ->
                        new EntityNotFoundException("Can't find department by name = "
                                + departmentName));
        return department.getLectors().size();
    }
}
