package com.eevan.registry.services;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.PC;
import com.eevan.registry.repos.PCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PCService {
    private final PCRepository pcRepository;

    @Transactional
    public void save(PC pc) {
        pcRepository.save(pc);
    }
}
