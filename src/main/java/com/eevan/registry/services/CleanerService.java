package com.eevan.registry.services;

import com.eevan.registry.repos.CleanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CleanerService {
    private final CleanerRepository cleanerRepository;

    @Autowired
    public CleanerService(CleanerRepository cleanerRepository) {
        this.cleanerRepository = cleanerRepository;
    }
}
