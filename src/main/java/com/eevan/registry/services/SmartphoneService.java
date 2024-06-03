package com.eevan.registry.services;

import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.Smartphone;
import com.eevan.registry.repos.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SmartphoneService {
    private final SmartphoneRepository smartphoneRepository;

    @Autowired
    public SmartphoneService(SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    @Transactional
    public void save(Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }
}
