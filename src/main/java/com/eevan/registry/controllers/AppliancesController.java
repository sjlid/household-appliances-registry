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


    @PostMapping("/products")
    public ProductFamilyResponseDto addProductFamily(
            @RequestBody @Valid ProductFamilyDto productFamilyDto,
            BindingResult bindingResult
    ) {
        ErrorCreatingExceptionThrow(bindingResult);
        ProductFamily createdProductFamily = convertToProductFamily(productFamilyDto);
        return convertToProductFamilyResponseDto(productFamilyService.save(createdProductFamily));
    }


    @PostMapping("/products/cleaners")
    public ResponseEntity<HttpStatus> addCleaner(
            @RequestBody @Valid CleanerDto cleanerDto,
            BindingResult bindingResult
    ) {
        ErrorCreatingExceptionThrow(bindingResult);
        cleanerService.save(cleanerDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/products/fridges")
    public ResponseEntity<HttpStatus> addFridge(
            @RequestBody @Valid FridgeDto fridgeDto,
            BindingResult bindingResult
    ) {
        ErrorCreatingExceptionThrow(bindingResult);
        fridgeService.save(fridgeDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/products/pcs")
    public ResponseEntity<HttpStatus> addPc(
            @RequestBody @Valid PcDto pcDto,
            BindingResult bindingResult
    ) {
        ErrorCreatingExceptionThrow(bindingResult);
        pcService.save(pcDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/products/smartphones")
    public ResponseEntity<HttpStatus> addSmartphone(
            @RequestBody @Valid SmartphoneDto smartphoneDto,
            BindingResult bindingResult
    ) {
        ErrorCreatingExceptionThrow(bindingResult);
        smartphoneService.save(smartphoneDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/products/tvs")
    public ResponseEntity<HttpStatus> addTv(
            @RequestBody @Valid TvDto tvDto,
            BindingResult bindingResult
    ) {
        ErrorCreatingExceptionThrow(bindingResult);
        tvService.save(tvDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

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

    private ProductDto convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private ProductFamily convertToProductFamily(ProductFamilyDto productFamilyDto) {
        return modelMapper.map(productFamilyDto, ProductFamily.class);
    }

    private ProductFamilyDto convertToProductFamilyDTO(ProductFamily productFamily) {
        return modelMapper.map(productFamily, ProductFamilyDto.class);
    }

    private ProductFamilyResponseDto convertToProductFamilyResponseDto(ProductFamily productFamily) {
        return modelMapper.map(productFamily, ProductFamilyResponseDto.class);
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

    private void ErrorCreatingExceptionThrow(BindingResult bindingResult) {
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
    }
}
