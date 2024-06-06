package com.eevan.registry.controllers;

import com.eevan.registry.dtos.*;
import com.eevan.registry.entities.*;
import com.eevan.registry.services.*;
import com.eevan.registry.utils.ApplianceErrorResponse;
import com.eevan.registry.utils.ApplianceNotFoundException;
import com.eevan.registry.utils.ModelNotCreatedException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppliancesController {

    private final CleanerService cleanerService;
    private final FridgeService fridgeService;
    private final PcService pcService;
    private final SmartphoneService smartphoneService;
    private final TvService tvService;
    private final ProductService productService;
    private final ProductFamilyService productFamilyService;
    private final ModelMapper modelMapper;


    @GetMapping("/products/byAlphabet")
    public Stream<ProductDto> getAllProductsWithSortingByAlphabet(@RequestParam String direction) {
        return productService.getAllProductsWithSortingByAlphabet(direction)
                .stream()
                .map(this::convertToProductDTO);
    }

    @GetMapping("/products/byPrice")
    public Stream<ProductDto> getAllProductsWithSortingByPrice(@RequestParam String direction) {
        return productService.getAllProductsWithSortingByPrice(direction)
                .stream()
                .map(this::convertToProductDTO);
    }

    @PostMapping("/products")
    public ResponseEntity<HttpStatus> addProductFamily(@RequestBody @Valid ProductFamilyDto productFamilyDto,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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
        productFamilyService.save(convertToProductFamily(productFamilyDto));

        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PostMapping("/products/cleaners")
    public ResponseEntity<HttpStatus> addCleaner(@RequestBody @Valid CleanerDto cleanerDTO,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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

    @PostMapping("/products/fridges")
    public ResponseEntity<HttpStatus> addFridge(@RequestBody @Valid FridgeDto fridgeDTO,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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

    @PostMapping("/products/pcs")
    public ResponseEntity<HttpStatus> addPc(@RequestBody @Valid PcDto pcDTO,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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

    @PostMapping("/products/smartphones")
    public ResponseEntity<HttpStatus> addSmartphone(@RequestBody @Valid SmartphoneDto smartphoneDTO,
                                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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

    @PostMapping("/products/tvs")
    public ResponseEntity<HttpStatus> addTv(@RequestBody @Valid TvDto tvDTO,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
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


    private Cleaner convertToCleaner(CleanerDto cleanerDTO) {
        return modelMapper.map(cleanerDTO, Cleaner.class);
    }

    private CleanerDto convertToCleanerDTO(Cleaner cleaner) {
        return modelMapper.map(cleaner, CleanerDto.class);
    }

    private Fridge convertToFridge(FridgeDto fridgeDTO) {
        return modelMapper.map(fridgeDTO, Fridge.class);
    }

    private FridgeDto convertToFridgeDTO(Fridge fridge) {
        return modelMapper.map(fridge, FridgeDto.class);
    }

    private Pc convertToPC(PcDto pcDTO) {
        return modelMapper.map(pcDTO, Pc.class);
    }

    private PcDto convertToPcDTO(Pc pc) {
        return modelMapper.map(pc, PcDto.class);
    }

    private Smartphone convertToSmartphone(SmartphoneDto smartphoneDTO) {
        return modelMapper.map(smartphoneDTO, Smartphone.class);
    }

    private SmartphoneDto convertToSmartphoneDTO(Smartphone smartphone) {
        return modelMapper.map(smartphone, SmartphoneDto.class);
    }

    private Tv convertToTV(TvDto tvDTO) {
        return modelMapper.map(tvDTO, Tv.class);
    }

    private TvDto convertToTvDTO(Tv tv) {
        return modelMapper.map(tv, TvDto.class);
    }

    private ProductDto convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private ProductFamily convertToProductFamily(ProductFamilyDto productFamilyDto) {
        return modelMapper.map(productFamilyDto, ProductFamily.class);
    }
    private ProductFamilyDto convertToProductFamilyDTO(ProductFamily productFamily) {
        return modelMapper.map(productFamily, ProductFamilyDto.class);
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
