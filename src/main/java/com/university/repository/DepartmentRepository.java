package com.university.repository;

import com.university.model.Department;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);

    @Query("FROM Department d LEFT JOIN FETCH d.lectors WHERE d.name = :name")
    Optional<Department> findByNameWithEmployees(String name);
}
