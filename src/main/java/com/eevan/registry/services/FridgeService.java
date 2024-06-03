package com.eevan.registry.services;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.Fridge;
import com.eevan.registry.repos.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FridgeService {
    private final FridgeRepository fridgeRepository;

    @Autowired
    public FridgeService(FridgeRepository fridgeRepository) {
        this.fridgeRepository = fridgeRepository;
    }

    @Transactional
    public void save(Fridge fridge) {
        fridgeRepository.save(fridge);
    }
}
