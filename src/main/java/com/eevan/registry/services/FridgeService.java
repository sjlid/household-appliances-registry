package com.eevan.registry.services;

import com.eevan.registry.dtos.FridgeDto;
import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.repos.FridgeRepository;
import com.eevan.registry.repos.ProductFamilyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class FridgeService {
    private final FridgeRepository fridgeRepository;
    private final ProductFamilyRepository productFamilyRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void save(FridgeDto fridgeDto) {
        ProductFamily productFamily = productFamilyRepository.getFamilyById(fridgeDto.getProductFamilyId());
        Fridge fridge = convertToFridge(fridgeDto);
        fridge.setProductFamily(productFamily);
        fridgeRepository.save(fridge);
    }

    private Fridge convertToFridge(FridgeDto fridgeDto) {
        return modelMapper.map(fridgeDto, Fridge.class);
    }
}
