package com.eevan.registry.services;

import com.eevan.registry.dtos.FridgeDto;
import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.repos.FridgeRepository;
import com.eevan.registry.repos.ProductFamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FridgeService {
    private final FridgeRepository fridgeRepository;
    private final ProductFamilyRepository productFamilyRepository;

    @Transactional
    public void save(FridgeDto fridgeDto) {
        ProductFamily productFamily = productFamilyRepository.getFamilyById(fridgeDto.getProductFamilyId());
        Fridge fridge = convertToFridge(fridgeDto);
        fridge.setProductFamily(productFamily);
        if (fridge.getModelAvailability()) {
            int totalModels = productFamily.getAvailableProducts() + 1;
            productFamily.setAvailableProducts(totalModels);
            productFamilyRepository.save(productFamily);
        }
        fridgeRepository.save(fridge);
    }

    @Transactional(readOnly = true)
    public List<Fridge> getAllFridges() {
        return fridgeRepository.findAll();
    }

    private Fridge convertToFridge(FridgeDto fridgeDto) {
        Fridge fridge = new Fridge();
        fridge.setModelName(fridgeDto.getModelName());
        fridge.setModelSerialNumber(fridgeDto.getModelSerialNumber());
        fridge.setProductType(fridgeDto.getProductType().toString());
        fridge.setModelSize(fridgeDto.getModelSize());
        fridge.setModelColor(fridgeDto.getModelColor());
        fridge.setModelPrice(fridgeDto.getModelPrice());
        fridge.setModelAvailability(fridgeDto.getModelAvailability());
        fridge.setModelCompressor(fridgeDto.getModelCompressor());
        fridge.setModelDoors(fridgeDto.getModelDoors());
        return fridge;
    }
}
