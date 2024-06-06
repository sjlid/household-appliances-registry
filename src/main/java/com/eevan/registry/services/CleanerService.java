package com.eevan.registry.services;

import com.eevan.registry.dtos.CleanerDto;
import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.repos.CleanerRepository;
import com.eevan.registry.repos.ProductFamilyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CleanerService {
    private final CleanerRepository cleanerRepository;
    private final ProductFamilyRepository productFamilyRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void save(CleanerDto cleanerDto) {
        ProductFamily productFamily = productFamilyRepository.getFamilyById(cleanerDto.getProductFamilyId());
        Cleaner cleaner = convertToCleaner(cleanerDto);
        cleaner.setProductFamily(productFamily);
        cleanerRepository.save(cleaner);
    }

    private Cleaner convertToCleaner(CleanerDto cleanerDTO) {
        return modelMapper.map(cleanerDTO, Cleaner.class);
    }
}
