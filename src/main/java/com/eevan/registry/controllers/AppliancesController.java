package com.eevan.registry.controllers;

import com.eevan.registry.dtos.*;
import com.eevan.registry.entities.*;
import com.eevan.registry.services.*;
import com.eevan.registry.utils.ApplianceErrorResponse;
import com.eevan.registry.utils.ProductFamilyNotCreatedException;
import com.eevan.registry.utils.ProductFamilyNotFoundException;
import com.eevan.registry.utils.ProductNotCreatedException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Create product family", description = "Here you can create a family of different types of product", tags = { "product" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product family has created"),
            @ApiResponse(responseCode = "400", description = "Not all the necessary fields are filled"),
            @ApiResponse(responseCode = "500", description = "Not all the necessary fields are present in DTO or has correct values")
    })
    @PostMapping("/products")
    public ProductFamilyResponseDto addProductFamily(
            @RequestBody @Valid ProductFamilyDto productFamilyDto,
            BindingResult bindingResult
    ) {
        ErrorProductFamilyCreatingExceptionThrow(bindingResult);
        ProductFamily createdProductFamily = convertToProductFamily(productFamilyDto);
        return convertToProductFamilyResponseDto(productFamilyService.save(createdProductFamily));
    }

    @Operation(summary = "Create a model of cleaner", description = "Here you can create a model for cleaner's family has yet created", tags = { "cleaner" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Model has created"),
            @ApiResponse(responseCode = "400", description = "Not all the necessary fields are filled"),
            @ApiResponse(responseCode = "500", description = "Not all the necessary fields are present in DTO or has correct values")
    })
    @PostMapping("/products/cleaners")
    public ResponseEntity<HttpStatus> addCleaner(
            @Parameter(description = "Create a new model of cleaner in the registry", required = true)
            @RequestBody @Valid CleanerDto cleanerDto,
            BindingResult bindingResult
    ) {
        ErrorProductCreatingExceptionThrow(bindingResult);
        cleanerService.save(cleanerDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Get all the cleaners with all the model's filters", tags = { "cleaner" })
    @GetMapping("/products/cleaners")
    public Stream<CleanerDto> searchAndFilterCleaners(
            @Parameter(description = "The model name for filter", required = false) @RequestParam(required = false) String modelName,
            @Parameter(description = "The model's serial number for filter", required = false) @RequestParam(required = false) String modelSerialNumber,
            @Parameter(description = "The model's color for filter", required = false) @RequestParam(required = false) String modelColor,
            @Parameter(description = "The model's size for filter", required = false) @RequestParam(required = false) String modelSize,
            @Parameter(description = "The model's min price  for filter", required = false) @RequestParam(required = false) BigDecimal minPrice,
            @Parameter(description = "The model's max price for filter", required = false) @RequestParam(required = false) BigDecimal maxPrice,
            @Parameter(description = "The model's volume for filter", required = false) @RequestParam(required = false) Float modelVolume,
            @Parameter(description = "The model's work modes for filter", required = false) @RequestParam(required = false) String modelWorkModes,
            @Parameter(description = "The model's availability for filter", required = false) @RequestParam(required = false) Boolean modelAvailability
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

    @Operation(summary = "Create a model of fridge", description = "Here you can create a model for fridge's family has yet created", tags = { "fridge" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Model has created"),
            @ApiResponse(responseCode = "400", description = "Not all the necessary fields are filled"),
            @ApiResponse(responseCode = "500", description = "Not all the necessary fields are present in DTO or has correct values")
    })
    @PostMapping("/products/fridges")
    public ResponseEntity<HttpStatus> addFridge(
            @Parameter(description = "Create a new model of fridge in the registry", required = true)
            @RequestBody @Valid FridgeDto fridgeDto,
            BindingResult bindingResult
    ) {
        ErrorProductCreatingExceptionThrow(bindingResult);
        fridgeService.save(fridgeDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Get all the fridges with all the model's filters", tags = { "fridge" })
    @GetMapping("/products/fridges")
    public Stream<FridgeDto> searchAndFilterFridges(
            @Parameter(description = "The model name for filter", required = false) @RequestParam(required = false) String modelName,
            @Parameter(description = "The model's serial number for filter", required = false) @RequestParam(required = false) String modelSerialNumber,
            @Parameter(description = "The model's color for filter", required = false) @RequestParam(required = false) String modelColor,
            @Parameter(description = "The model's size for filter", required = false) @RequestParam(required = false) String modelSize,
            @Parameter(description = "The model's min price  for filter", required = false) @RequestParam(required = false) BigDecimal minPrice,
            @Parameter(description = "The model's max price for filter", required = false) @RequestParam(required = false) BigDecimal maxPrice,
            @Parameter(description = "The model's quantity of doors for filter", required = false) @RequestParam(required = false) Integer modelDoors,
            @Parameter(description = "The model's compressor for filter", required = false) @RequestParam(required = false) String modelCompressor,
            @Parameter(description = "The model's availability for filter", required = false) @RequestParam(required = false) Boolean modelAvailability
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

    @Operation(summary = "Create a model of PC", description = "Here you can create a model for PC's family has yet created", tags = { "pc" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Model has created"),
            @ApiResponse(responseCode = "400", description = "Not all the necessary fields are filled"),
            @ApiResponse(responseCode = "500", description = "Not all the necessary fields are present in DTO or has correct values")
    })
    @PostMapping("/products/pcs")
    public ResponseEntity<HttpStatus> addPc(
            @Parameter(description = "Create a new model of PC in the registry", required = true)
            @RequestBody @Valid PcDto pcDto,
            BindingResult bindingResult
    ) {
        ErrorProductCreatingExceptionThrow(bindingResult);
        pcService.save(pcDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Get all the PCs with all the model's filters", tags = { "pc" })
    @GetMapping("/products/pcs")
    public Stream<PcDto> searchAndFilterPcs(
            @Parameter(description = "The model name for filter", required = false) @RequestParam(required = false) String modelName,
            @Parameter(description = "The model's serial number for filter", required = false) @RequestParam(required = false) String modelSerialNumber,
            @Parameter(description = "The model's color for filter", required = false) @RequestParam(required = false) String modelColor,
            @Parameter(description = "The model's size for filter", required = false) @RequestParam(required = false) String modelSize,
            @Parameter(description = "The model's min price  for filter", required = false) @RequestParam(required = false) BigDecimal minPrice,
            @Parameter(description = "The model's max price for filter", required = false) @RequestParam(required = false) BigDecimal maxPrice,
            @Parameter(description = "The model's category for filter", required = false) @RequestParam(required = false) String modelCategory,
            @Parameter(description = "The model's processor for filter", required = false) @RequestParam(required = false) String modelProcessor,
            @Parameter(description = "The model's availability for filter", required = false) @RequestParam(required = false) Boolean modelAvailability
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

    @Operation(summary = "Create a model of smartphone", description = "Here you can create a model for smartphone's family has yet created", tags = { "smartphone" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Model has created"),
            @ApiResponse(responseCode = "400", description = "Not all the necessary fields are filled"),
            @ApiResponse(responseCode = "500", description = "Not all the necessary fields are present in DTO or has correct values")
    })
    @PostMapping("/products/smartphones")
    public ResponseEntity<HttpStatus> addSmartphone(
            @Parameter(description = "Create a new model of smartphone in the registry", required = true)
            @RequestBody @Valid SmartphoneDto smartphoneDto,
            BindingResult bindingResult
    ) {
        ErrorProductCreatingExceptionThrow(bindingResult);
        smartphoneService.save(smartphoneDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Get all the smartphones with all the model's filters", tags = { "smartphone" })
    @GetMapping("/products/smartphones")
    public Stream<SmartphoneDto> searchAndFilterSmartphones(
            @Parameter(description = "The model name for filter", required = false) @RequestParam(required = false) String modelName,
            @Parameter(description = "The model's serial number for filter", required = false) @RequestParam(required = false) String modelSerialNumber,
            @Parameter(description = "The model's color for filter", required = false) @RequestParam(required = false) String modelColor,
            @Parameter(description = "The model's size for filter", required = false) @RequestParam(required = false) String modelSize,
            @Parameter(description = "The model's min price  for filter", required = false) @RequestParam(required = false) BigDecimal minPrice,
            @Parameter(description = "The model's max price for filter", required = false) @RequestParam(required = false) BigDecimal maxPrice,
            @Parameter(description = "The model's memory for filter", required = false) @RequestParam(required = false) Integer modelMemory,
            @Parameter(description = "The model's camera for filter", required = false) @RequestParam(required = false) String modelCamera,
            @Parameter(description = "The model's availability for filter", required = false) @RequestParam(required = false) Boolean modelAvailability
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

    @Operation(summary = "Create a model of TV", description = "Here you can create a model for TV's family has yet created", tags = { "tv" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Model has created"),
            @ApiResponse(responseCode = "400", description = "Not all the necessary fields are filled"),
            @ApiResponse(responseCode = "500", description = "Not all the necessary fields are present in DTO or has correct values")
    })
    @PostMapping("/products/tvs")
    public ResponseEntity<HttpStatus> addTv(
            @Parameter(description = "Create a new model of TV in the registry", required = true)
            @RequestBody @Valid TvDto tvDto,
            BindingResult bindingResult
    ) {
        ErrorProductCreatingExceptionThrow(bindingResult);
        tvService.save(tvDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Get all the TVs with all the model's filters", tags = { "tv" })
    @GetMapping("/products/tvs")
    public Stream<TvDto> searchAndFilterTvs(
            @Parameter(description = "The model name for filter", required = false) @RequestParam(required = false) String modelName,
            @Parameter(description = "The model's serial number for filter", required = false) @RequestParam(required = false) String modelSerialNumber,
            @Parameter(description = "The model's color for filter", required = false) @RequestParam(required = false) String modelColor,
            @Parameter(description = "The model's size for filter", required = false) @RequestParam(required = false) String modelSize,
            @Parameter(description = "The model's min price  for filter", required = false) @RequestParam(required = false) BigDecimal minPrice,
            @Parameter(description = "The model's max price for filter", required = false) @RequestParam(required = false) BigDecimal maxPrice,
            @Parameter(description = "The model's category for filter", required = false) @RequestParam(required = false) String modelCategory,
            @Parameter(description = "The model's technology for filter", required = false) @RequestParam(required = false) String modelTechnology,
            @Parameter(description = "The model's availability for filter", required = false) @RequestParam(required = false) Boolean modelAvailability
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

    @Operation(summary = "Get all the models in DB with possibility to sorting by alphabet in both directions", tags = { "product" })
    @GetMapping("/products/byAlphabet")
    public Stream<ProductDto> getAllProductsWithSortingByAlphabet(
            @Parameter(description = "The direction for sorting by alphabet: ASC or DESC", required = true)
            @RequestParam String direction) {
        return productService.getAllProductsWithSortingByAlphabet(direction)
                .stream()
                .map(this::convertToProductDTO);
    }

    @Operation(summary = "Get all the models in DB with possibility to sorting by price in both directions", tags = { "product" })
    @GetMapping("/products/byPrice")
    public Stream<ProductDto> getAllProductsWithSortingByPrice(
            @Parameter(description = "The direction for sorting by price: ASC or DESC", required = true)
            @RequestParam String direction) {
        return productService.getAllProductsWithSortingByPrice(direction)
                .stream()
                .map(this::convertToProductDTO);
    }

    @Operation(summary = "Get all the products by its name (family + model as example) with possibility to use the following filters: product type, color and price(from...to...)", tags = { "product" })
    @GetMapping("/products/search")
    public Stream<ProductDto> searchAndFilterProducts(
            @Parameter(description = "Name for searching that can contain both of family and model name for filter", required = true) @RequestParam String searchValue,
            @Parameter(description = "The product's type for filter", required = false) @RequestParam(required = false) String productType,
            @Parameter(description = "The model's color for filter", required = false) @RequestParam(required = false) String modelColor,
            @Parameter(description = "The model's min price for filter", required = false) @RequestParam(required = false) BigDecimal minPrice,
            @Parameter(description = "The model's max price for filter", required = false) @RequestParam(required = false) BigDecimal maxPrice
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
    private ResponseEntity<ApplianceErrorResponse> handleException(ProductNotCreatedException e) {
        ApplianceErrorResponse response = new ApplianceErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private void ErrorProductCreatingExceptionThrow(BindingResult bindingResult) {
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

    private void ErrorProductFamilyCreatingExceptionThrow(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMessage.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(" ; ");
            }
            throw new ProductFamilyNotCreatedException(errorMessage.toString());
        }
    }
}
