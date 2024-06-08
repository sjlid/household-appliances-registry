package com.eevan.registry.controllers;

import com.eevan.registry.dtos.*;
import com.eevan.registry.entities.*;
import com.eevan.registry.services.*;
import com.eevan.registry.utils.ApplianceErrorResponse;
import com.eevan.registry.utils.ProductNotFoundException;
import com.eevan.registry.utils.ProductNotCreatedException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
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

    @GetMapping("/products/cleaners")
    public Stream<CleanerDto> searchAndFilterCleaners(
            @RequestParam(required = false) String modelName,
            @RequestParam(required = false) String modelSerialNumber,
            @RequestParam(required = false) String modelColor,
            @RequestParam(required = false) String modelSize,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Float modelVolume,
            @RequestParam(required = false) String modelWorkModes,
            @RequestParam(required = false) Boolean modelAvailability
    ) {
        return cleanerService.getAllCleaners()
                .stream()
                .filter(product -> modelName == null || product
                        .getModelName()
                        .equalsIgnoreCase(modelName))
                .filter(product -> modelSerialNumber == null || product
                        .getModelSerialNumber()
                        .equalsIgnoreCase(modelSerialNumber))
                .filter(product -> modelColor == null || product
                        .getModelColor()
                        .equalsIgnoreCase(modelColor))
                .filter(product -> modelSize == null || product
                        .getModelSize()
                        .equalsIgnoreCase(modelSize))
                .filter(product -> minPrice == null || (product
                        .getModelPrice())
                        .compareTo(minPrice) >= 0)
                .filter(product -> maxPrice == null || (product
                        .getModelPrice())
                        .compareTo(maxPrice) <= 0)
                .filter(product -> modelVolume == null || product
                        .getModelVolume()
                        .equals(modelVolume))
                .filter(product -> modelWorkModes == null || product
                        .getModelSize()
                        .equalsIgnoreCase(modelWorkModes))
                .filter(product -> modelAvailability == null || product
                        .getModelAvailability()
                        .equals(modelAvailability))
                .map(this::convertToCleanerDto);
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

    @GetMapping("/products/fridges")
    public Stream<FridgeDto> searchAndFilterFridges(
            @RequestParam(required = false) String modelName,
            @RequestParam(required = false) String modelSerialNumber,
            @RequestParam(required = false) String modelColor,
            @RequestParam(required = false) String modelSize,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Integer modelDoors,
            @RequestParam(required = false) String modelCompressor,
            @RequestParam(required = false) Boolean modelAvailability
    ) {
        return fridgeService.getAllFridges()
                .stream()
                .filter(product -> modelName == null || product
                        .getModelName()
                        .equalsIgnoreCase(modelName))
                .filter(product -> modelSerialNumber == null || product
                        .getModelSerialNumber()
                        .equalsIgnoreCase(modelSerialNumber))
                .filter(product -> modelColor == null || product
                        .getModelColor()
                        .equalsIgnoreCase(modelColor))
                .filter(product -> modelSize == null || product
                        .getModelSize()
                        .equalsIgnoreCase(modelSize))
                .filter(product -> minPrice == null || (product
                        .getModelPrice())
                        .compareTo(minPrice) >= 0)
                .filter(product -> maxPrice == null || (product
                        .getModelPrice())
                        .compareTo(maxPrice) <= 0)
                .filter(product -> modelDoors == null || product
                        .getModelDoors()
                        .equals(modelDoors))
                .filter(product -> modelCompressor == null || product
                        .getModelCompressor()
                        .equalsIgnoreCase(modelCompressor))
                .filter(product -> modelAvailability == null || product
                        .getModelAvailability()
                        .equals(modelAvailability))
                .map(this::convertToFridgeDto);
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

    @GetMapping("/products/pcs")
    public Stream<PcDto> searchAndFilterPcs(
            @RequestParam(required = false) String modelName,
            @RequestParam(required = false) String modelSerialNumber,
            @RequestParam(required = false) String modelColor,
            @RequestParam(required = false) String modelSize,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) String modelCategory,
            @RequestParam(required = false) String modelProcessor,
            @RequestParam(required = false) Boolean modelAvailability
    ) {
        return pcService.getAllPcs()
                .stream()
                .filter(product -> modelName == null || product
                        .getModelName()
                        .equalsIgnoreCase(modelName))
                .filter(product -> modelSerialNumber == null || product
                        .getModelSerialNumber()
                        .equalsIgnoreCase(modelSerialNumber))
                .filter(product -> modelColor == null || product
                        .getModelColor()
                        .equalsIgnoreCase(modelColor))
                .filter(product -> modelSize == null || product
                        .getModelSize()
                        .equalsIgnoreCase(modelSize))
                .filter(product -> minPrice == null || (product
                        .getModelPrice())
                        .compareTo(minPrice) >= 0)
                .filter(product -> maxPrice == null || (product
                        .getModelPrice())
                        .compareTo(maxPrice) <= 0)
                .filter(product -> modelCategory == null || product
                        .getModelCategory()
                        .equals(modelCategory))
                .filter(product -> modelProcessor == null || product
                        .getModelProcessor()
                        .equalsIgnoreCase(modelProcessor))
                .filter(product -> modelAvailability == null || product
                        .getModelAvailability()
                        .equals(modelAvailability))
                .map(this::convertToPcDto);
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

    @GetMapping("/products/smartphones")
    public Stream<SmartphoneDto> searchAndFilterSmartphones(
            @RequestParam(required = false) String modelName,
            @RequestParam(required = false) String modelSerialNumber,
            @RequestParam(required = false) String modelColor,
            @RequestParam(required = false) String modelSize,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) Integer modelMemory,
            @RequestParam(required = false) String modelCamera,
            @RequestParam(required = false) Boolean modelAvailability
    ) {
        return smartphoneService.getAllSmartphones()
                .stream()
                .filter(product -> modelName == null || product
                        .getModelName()
                        .equalsIgnoreCase(modelName))
                .filter(product -> modelSerialNumber == null || product
                        .getModelSerialNumber()
                        .equalsIgnoreCase(modelSerialNumber))
                .filter(product -> modelColor == null || product
                        .getModelColor()
                        .equalsIgnoreCase(modelColor))
                .filter(product -> modelSize == null || product
                        .getModelSize()
                        .equalsIgnoreCase(modelSize))
                .filter(product -> minPrice == null || (product
                        .getModelPrice())
                        .compareTo(minPrice) >= 0)
                .filter(product -> maxPrice == null || (product
                        .getModelPrice())
                        .compareTo(maxPrice) <= 0)
                .filter(product -> modelMemory == null || product
                        .getModelMemory()
                        .equals(modelMemory))
                .filter(product -> modelCamera == null || product
                        .getModelCamera()
                        .equalsIgnoreCase(modelCamera))
                .filter(product -> modelAvailability == null || product
                        .getModelAvailability()
                        .equals(modelAvailability))
                .map(this::convertToSmartphoneDto);
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

    @GetMapping("/products/tvs")
    public Stream<TvDto> searchAndFilterTvs(
            @RequestParam(required = false) String modelName,
            @RequestParam(required = false) String modelSerialNumber,
            @RequestParam(required = false) String modelColor,
            @RequestParam(required = false) String modelSize,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) String modelCategory,
            @RequestParam(required = false) String modelTechnology,
            @RequestParam(required = false) Boolean modelAvailability
    ) {
        return tvService.getAllTvs()
                .stream()
                .filter(product -> modelName == null || product
                        .getModelName()
                        .equalsIgnoreCase(modelName))
                .filter(product -> modelSerialNumber == null || product
                        .getModelSerialNumber()
                        .equalsIgnoreCase(modelSerialNumber))
                .filter(product -> modelColor == null || product
                        .getModelColor()
                        .equalsIgnoreCase(modelColor))
                .filter(product -> modelSize == null || product
                        .getModelSize()
                        .equalsIgnoreCase(modelSize))
                .filter(product -> minPrice == null || (product
                        .getModelPrice())
                        .compareTo(minPrice) >= 0)
                .filter(product -> maxPrice == null || (product
                        .getModelPrice())
                        .compareTo(maxPrice) <= 0)
                .filter(product -> modelCategory == null || product
                        .getModelCategory()
                        .equals(modelCategory))
                .filter(product -> modelTechnology == null || product
                        .getModelTechnology()
                        .equalsIgnoreCase(modelTechnology))
                .filter(product -> modelAvailability == null || product
                        .getModelAvailability()
                        .equals(modelAvailability))
                .map(this::convertToTvDto);
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

    /*
    @GetMapping("/products/search")
    public Stream<ProductDto> searchAndFilterProducts(
            @RequestParam(required = false) String searchValue,
            @RequestParam(required = false) String productType,
            @RequestParam(required = false) String modelColor,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice
    ) {
        return productService.getProductsByModelNameOrFamilyName(searchValue)
                .stream()
                .filter(product -> productType == null || product
                        .getProductType()
                        .equalsIgnoreCase(productType))
                .filter(product -> modelColor == null || product
                        .getModelColor()
                        .equalsIgnoreCase(modelColor))
                .filter(product -> minPrice == null || (product
                        .getModelPrice())
                        .compareTo(minPrice) >= 0)
                .filter(product -> maxPrice == null || (product
                        .getModelPrice())
                        .compareTo(maxPrice) <= 0)
                .map(this::convertToProductDTO);
    }
     */

    private CleanerDto convertToCleanerDto(Cleaner cleaner) {
        return modelMapper.map(cleaner, CleanerDto.class);
    }

    private FridgeDto convertToFridgeDto(Fridge fridge) {
        return modelMapper.map(fridge, FridgeDto.class);
    }

    private PcDto convertToPcDto(Pc pc) {
        return modelMapper.map(pc, PcDto.class);
    }

    private SmartphoneDto convertToSmartphoneDto(Smartphone smartphone) {
        return modelMapper.map(smartphone, SmartphoneDto.class);
    }

    private TvDto convertToTvDto(Tv tv) {
        return modelMapper.map(tv, TvDto.class);
    }

    private ProductDto convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    private ProductFamily convertToProductFamily(ProductFamilyDto productFamilyDto) {
        return modelMapper.map(productFamilyDto, ProductFamily.class);
    }

    private ProductFamilyResponseDto convertToProductFamilyResponseDto(ProductFamily productFamily) {
        return modelMapper.map(productFamily, ProductFamilyResponseDto.class);
    }

    @ExceptionHandler
    private ResponseEntity<ApplianceErrorResponse> handleException(ProductNotFoundException e) {
        ApplianceErrorResponse response = new ApplianceErrorResponse("Product not found!", System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<ApplianceErrorResponse> handleException(ProductNotCreatedException e) {
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
            throw new ProductNotCreatedException(errorMessage.toString());
        }
    }
}
