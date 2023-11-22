package com.university.service.impl;

import com.university.model.Lector;
import com.university.repository.LectorRepository;
import com.university.service.LectorService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;

    @Override
    public String findAllBySearchValue(String searchValue) {
        List<Lector> lectorsBySearchValue = lectorRepository.findAllBySearchValue(searchValue);
        return lectorsBySearchValue.stream()
                .map(Lector::getName)
                .collect(Collectors.joining(", "));
    }
}
