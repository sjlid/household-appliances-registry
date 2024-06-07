package com.eevan.registry.services;

import com.eevan.registry.dtos.SmartphoneDto;
import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.entities.Smartphone;
import com.eevan.registry.repos.ProductFamilyRepository;
import com.eevan.registry.repos.SmartphoneRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmartphoneService {
    private final SmartphoneRepository smartphoneRepository;
    private final ProductFamilyRepository productFamilyRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void save(SmartphoneDto smartphoneDto) {
        ProductFamily productFamily = productFamilyRepository.getFamilyById(smartphoneDto.getProductFamilyId());
        Smartphone smartphone = convertToSmartphone(smartphoneDto);
        smartphone.setProductFamily(productFamily);
        smartphoneRepository.save(smartphone);
    }

    @Transactional(readOnly = true)
    public List<Smartphone> getAllSmartphones() {
        return smartphoneRepository.findAll();
    }

    private Smartphone convertToSmartphone(SmartphoneDto smartphoneDto) {
        return modelMapper.map(smartphoneDto, Smartphone.class);
    }
}
