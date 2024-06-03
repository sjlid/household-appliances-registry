package com.eevan.registry.services;

import com.eevan.registry.entities.TV;
import com.eevan.registry.repos.TVRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TVService {
    private final TVRepository tvRepository;

    @Transactional
    public void save(TV tv) {
        tvRepository.save(tv);
    }
}
