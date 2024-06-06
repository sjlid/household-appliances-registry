package com.eevan.registry.services;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.repos.CleanerRepository;
import com.eevan.registry.repos.ProductFamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CleanerService {
    private final CleanerRepository cleanerRepository;
    private final ProductFamilyRepository productFamilyRepository;

    @Transactional
    public void save(Cleaner cleaner) {
        if (productFamilyRepository.
        cleaner.setProductFamily(productFamilyRepository.findByFamilyName("cleaner"));
        cleanerRepository.save(cleaner);
    }
}
