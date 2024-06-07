package com.eevan.registry.services;

import com.eevan.registry.dtos.PcDto;
import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.Pc;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.repos.PcRepository;
import com.eevan.registry.repos.ProductFamilyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PcService {
    private final PcRepository pcRepository;
    private final ProductFamilyRepository productFamilyRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void save(PcDto pcDto) {
        ProductFamily productFamily = productFamilyRepository.getFamilyById(pcDto.getProductFamilyId());
        Pc pc = convertToPc(pcDto);
        pc.setProductFamily(productFamily);
        pcRepository.save(pc);
    }

    @Transactional(readOnly = true)
    public List<Pc> getAllPcs() {
        return pcRepository.findAll();
    }

    private Pc convertToPc(PcDto pcDto) {
        return modelMapper.map(pcDto, Pc.class);
    }
}
