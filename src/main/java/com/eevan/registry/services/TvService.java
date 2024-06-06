package com.eevan.registry.services;

import com.eevan.registry.entities.Tv;
import com.eevan.registry.repos.TvRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TvService {
    private final TvRepository tvRepository;

    @Transactional
    public void save(Tv tv) {
        tvRepository.save(tv);
    }
}
