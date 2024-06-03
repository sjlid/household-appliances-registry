package com.eevan.registry.services;

import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.PC;
import com.eevan.registry.repos.PCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PCService {
    private final PCRepository pcRepository;

    @Autowired
    public PCService(PCRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    @Transactional
    public void save(PC pc) {
        pcRepository.save(pc);
    }
}
