package com.eevan.registry.services;

import com.eevan.registry.entities.Smartphone;
import com.eevan.registry.repos.SmartphoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SmartphoneService {
    private final SmartphoneRepository smartphoneRepository;

    @Transactional
    public void save(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }
}
