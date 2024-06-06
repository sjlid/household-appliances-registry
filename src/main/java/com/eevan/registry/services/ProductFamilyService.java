package com.eevan.registry.services;

import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.repos.ProductFamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductFamilyService {

    private final ProductFamilyRepository productFamilyRepository;

    @Transactional
    public void save(ProductFamily productFamily) {
        productFamilyRepository.save(productFamily);
    }
}
