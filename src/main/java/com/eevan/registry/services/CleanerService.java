package com.eevan.registry.services;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.repos.CleanerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CleanerService {
    private final CleanerRepository cleanerRepository;

    @Transactional
    public void save(Cleaner cleaner) {
        cleanerRepository.save(cleaner);
    }
}
