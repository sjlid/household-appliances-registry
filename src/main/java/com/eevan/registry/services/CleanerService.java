package com.eevan.registry.services;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.repos.CleanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CleanerService {
    private final CleanerRepository cleanerRepository;

    @Autowired
    public CleanerService(CleanerRepository cleanerRepository) {
        this.cleanerRepository = cleanerRepository;
    }

    @Transactional
    public void save(Cleaner cleaner) {
        cleanerRepository.save(cleaner);
    }
}
