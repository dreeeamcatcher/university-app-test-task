package com.university.service;

import com.university.exception.EntityNotFoundException;
import com.university.model.Lector;
import java.util.List;

public interface DepartmentService {
    Lector getHeadOfDepartment(String departmentName) throws EntityNotFoundException;

    List<String> getDepartmentNames();

    String getDepartmentStatistics(String departmentName) throws EntityNotFoundException;

    Double getAverageSalaryOfDepartment(String departmentName) throws EntityNotFoundException;

    int countEmployeesForDepartment(String departmentName) throws EntityNotFoundException;
}
