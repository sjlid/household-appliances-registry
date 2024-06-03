package com.eevan.registry.services;

import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.TV;
import com.eevan.registry.repos.TVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TVService {
    private final TVRepository tvRepository;

    @Autowired
    public TVService(TVRepository tvRepository) {
        this.tvRepository = tvRepository;
    }

    @Transactional
    public void save(TV tv) {
        tvRepository.save(tv);
    }
}
