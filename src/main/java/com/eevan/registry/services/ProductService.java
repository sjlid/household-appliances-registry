package com.eevan.registry.services;

import com.eevan.registry.repos.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final CleanerRepository cleanerRepository;
    private final FridgeRepository fridgeRepository;
    private final PCRepository pcRepository;
    private final SmartphoneRepository smartphoneRepository;
    private final TVRepository tvRepository;

}
