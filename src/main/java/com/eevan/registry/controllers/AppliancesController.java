package com.eevan.registry.controllers;

import ch.qos.logback.core.net.server.Client;
import com.eevan.registry.dtos.*;
import com.eevan.registry.entities.*;
import com.eevan.registry.services.*;
import com.eevan.registry.utils.ApplianceErrorResponse;
import com.eevan.registry.utils.ApplianceNotFoundException;
import com.eevan.registry.utils.ModelNotCreatedException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/add/cleaner")
    public ResponseEntity<HttpStatus> addCleaner(@RequestBody @Valid CleanerDTO cleanerDTO,
                                                BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(" ; ");
            }
            throw new ModelNotCreatedException(errorMessage.toString());
        }
        cleanerService.save(convertToCleaner(cleanerDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/add/fridge")
    public ResponseEntity<HttpStatus> addFridge(@RequestBody @Valid FridgeDTO fridgeDTO,
                                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(" ; ");
            }
            throw new ModelNotCreatedException(errorMessage.toString());
        }
        fridgeService.save(convertToFridge(fridgeDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/add/pc")
    public ResponseEntity<HttpStatus> addPc(@RequestBody @Valid PcDTO pcDTO,
                                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(" ; ");
            }
            throw new ModelNotCreatedException(errorMessage.toString());
        }
        pcService.save(convertToPC(pcDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/add/smartphone")
    public ResponseEntity<HttpStatus> addSmartphone(@RequestBody @Valid SmartphoneDTO smartphoneDTO,
                                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(" ; ");
            }
            throw new ModelNotCreatedException(errorMessage.toString());
        }
        smartphoneService.save(convertToSmartphone(smartphoneDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/add/tv")
    public ResponseEntity<HttpStatus> addTv(@RequestBody @Valid TvDTO tvDTO,
                                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(" ; ");
            }
            throw new ModelNotCreatedException(errorMessage.toString());
        }
        tvService.save(convertToTV(tvDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }


    private Cleaner convertToCleaner(CleanerDTO cleanerDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cleanerDTO, Cleaner.class);
    }

    private CleanerDTO convertToCleanerDTO(Cleaner cleaner) {
        return modelMapper.map(cleaner, CleanerDTO.class);
    }

    private Fridge convertToFridge(FridgeDTO fridgeDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(fridgeDTO, Fridge.class);
    }

    private FridgeDTO convertToFridgeDTO(Fridge fridge) {
        return modelMapper.map(fridge, FridgeDTO.class);
    }

    private PC convertToPC(PcDTO pcDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pcDTO, PC.class);
    }

    private PcDTO convertToPcDTO(PC pc) {
        return modelMapper.map(pc, PcDTO.class);
    }

    private Smartphone convertToSmartphone(SmartphoneDTO smartphoneDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(smartphoneDTO, Smartphone.class);
    }

    private SmartphoneDTO convertToSmartphoneDTO(Smartphone smartphone) {
        return modelMapper.map(smartphone, SmartphoneDTO.class);
    }

    private TV convertToTV(TvDTO tvDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tvDTO, TV.class);
    }

    private TvDTO convertToTvDTO(TV tv) {
        return modelMapper.map(tv, TvDTO.class);
    }

    @ExceptionHandler
    private ResponseEntity<ApplianceErrorResponse> handleException(ApplianceNotFoundException e) {
        ApplianceErrorResponse response = new ApplianceErrorResponse("Appliance not found!", System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<ApplianceErrorResponse> handleException(ModelNotCreatedException e) {
        ApplianceErrorResponse response = new ApplianceErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
