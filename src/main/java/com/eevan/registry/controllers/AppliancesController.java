package com.eevan.registry.controllers;

import ch.qos.logback.core.net.server.Client;
import com.eevan.registry.dtos.CleanerDTO;
import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.services.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppliancesController {

    private final CleanerService cleanerService;
    private final FridgeService fridgeService;
    private final PCService pcService;
    private final SmartphoneService smartphoneService;
    private final TVService tvService;
    private final ModelMapper modelMapper;

    @Autowired
    public AppliancesController(CleanerService cleanerService, FridgeService fridgeService, PCService pcService, SmartphoneService smartphoneService, TVService tvService, ModelMapper modelMapper) {
        this.cleanerService = cleanerService;
        this.fridgeService = fridgeService;
        this.pcService = pcService;
        this.smartphoneService = smartphoneService;
        this.tvService = tvService;
        this.modelMapper = modelMapper;
    }

    private Cleaner convertToCleaner(CleanerDTO cleanerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cleanerDTO, Cleaner.class);
    }

    private CleanerDTO convertToCleanerDTO(Cleaner cleaner) {
        return modelMapper.map(cleaner, CleanerDTO.class);
    }

}
