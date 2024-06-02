package com.eevan.registry.services;

import com.eevan.registry.repos.TVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TVService {
    private final TVRepository tvRepository;

    @Autowired
    public TVService(TVRepository tvRepository) {
        this.tvRepository = tvRepository;
    }
}
