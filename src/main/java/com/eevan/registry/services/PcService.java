package com.eevan.registry.services;

import com.eevan.registry.dtos.PcDto;
import com.eevan.registry.entities.Pc;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.repos.PcRepository;
import com.eevan.registry.repos.ProductFamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PcService {
    private final PcRepository pcRepository;
    private final ProductFamilyRepository productFamilyRepository;

    @Transactional
    public void save(PcDto pcDto) {
        ProductFamily productFamily = productFamilyRepository.getFamilyById(pcDto.getProductFamilyId());
        Pc pc = convertToPc(pcDto);
        pc.setProductFamily(productFamily);
        if (pc.getModelAvailability()) {
            int totalModels = productFamily.getAvailableProducts() + 1;
            productFamily.setAvailableProducts(totalModels);
            productFamilyRepository.save(productFamily);
        }
        pcRepository.save(pc);
    }

    @Transactional(readOnly = true)
    public List<Pc> getAllPcs() {
        return pcRepository.findAll();
    }

    private Pc convertToPc(PcDto pcDto) {
        Pc pc = new Pc();
        pc.setModelName(pcDto.getModelName());
        pc.setModelSerialNumber(pcDto.getModelSerialNumber());
        pc.setProductType(pcDto.getProductType().toString());
        pc.setModelSize(pcDto.getModelSize());
        pc.setModelColor(pcDto.getModelColor());
        pc.setModelPrice(pcDto.getModelPrice());
        pc.setModelAvailability(pcDto.getModelAvailability());
        pc.setModelCategory(pcDto.getModelCategory());
        pc.setModelProcessor(pcDto.getModelProcessor());
        return pc;
    }
}
