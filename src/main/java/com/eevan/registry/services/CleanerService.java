package com.eevan.registry.services;

import com.eevan.registry.dtos.CleanerDto;
import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.repos.CleanerRepository;
import com.eevan.registry.repos.ProductFamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CleanerService {
    private final CleanerRepository cleanerRepository;
    private final ProductFamilyRepository productFamilyRepository;

    @Transactional
    public void save(CleanerDto cleanerDto) {
        ProductFamily productFamily = productFamilyRepository.getFamilyById(cleanerDto.getProductFamilyId());
        Cleaner cleaner = convertToCleaner(cleanerDto);
        cleaner.setProductFamily(productFamily);
        if (cleaner.getModelAvailability()) {
            int totalModels = productFamily.getAvailableProducts() + 1;
            productFamily.setAvailableProducts(totalModels);
            productFamilyRepository.save(productFamily);
        }
        cleanerRepository.save(cleaner);
    }

    @Transactional(readOnly = true)
    public List<Cleaner> getAllCleaners() {
        return cleanerRepository.findAll();
    }

    private Cleaner convertToCleaner(CleanerDto cleanerDTO) {
        Cleaner cleaner = new Cleaner();
        cleaner.setModelName(cleanerDTO.getModelName());
        cleaner.setModelSerialNumber(cleanerDTO.getModelSerialNumber());
        cleaner.setProductType(cleanerDTO.getProductType().toString());
        cleaner.setModelSize(cleanerDTO.getModelSize());
        cleaner.setModelColor(cleanerDTO.getModelColor());
        cleaner.setModelPrice(cleanerDTO.getModelPrice());
        cleaner.setModelAvailability(cleanerDTO.getModelAvailability());
        cleaner.setModelVolume(cleanerDTO.getModelVolume());
        cleaner.setModelWorkModes(cleanerDTO.getModelWorkModes());
        return cleaner;
    }
}
