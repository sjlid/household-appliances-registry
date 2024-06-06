package com.eevan.registry.services;

import com.eevan.registry.entities.Pc;
import com.eevan.registry.repos.PcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PcService {
    private final PcRepository pcRepository;

    @Transactional
    public void save(Pc pc) {
        pcRepository.save(pc);
    }
}
