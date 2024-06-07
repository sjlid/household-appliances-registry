package com.eevan.registry.services;

import com.eevan.registry.dtos.TvDto;
import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.entities.Tv;
import com.eevan.registry.repos.ProductFamilyRepository;
import com.eevan.registry.repos.TvRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TvService {
    private final TvRepository tvRepository;
    private final ProductFamilyRepository productFamilyRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public void save(TvDto tvDto) {
        ProductFamily productFamily = productFamilyRepository.getFamilyById(tvDto.getProductFamilyId());
        Tv tv = convertToPc(tvDto);
        tv.setProductFamily(productFamily);
        tvRepository.save(tv);
    }

    @Transactional(readOnly = true)
    public List<Tv> getAllTvs() {
        return tvRepository.findAll();
    }

    private Tv convertToPc(TvDto tvDto) {
        return modelMapper.map(tvDto, Tv.class);
    }
}
