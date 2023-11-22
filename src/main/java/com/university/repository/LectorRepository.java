package com.university.repository;

import com.university.model.Lector;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("FROM Lector l WHERE l.name like %:searchValue%")
    List<Lector> findAllBySearchValue(String searchValue);
}
