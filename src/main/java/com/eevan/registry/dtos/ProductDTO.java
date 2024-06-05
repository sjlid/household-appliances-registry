package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {
    @NotEmpty(message = "Product type should not be empty")
    private String productType;

    @NotEmpty(message = "Manufacturing country should not be empty")
    private String countryManufacturer;

    @NotEmpty(message = "Manufacturing company should not be empty")
    private String companyManufacturer;
    private Boolean isAbleToBuyOnline;
    private Boolean isAbleToInstallment;

    @NotEmpty(message = "Model's name should not be empty")
    private String modelName;

    @NotEmpty(message = "Model's serial should not be empty")
    private String modelSerialNumber;

    @NotEmpty(message = "Model's color should not be empty")
    private String modelColor;

    @NotEmpty(message = "Model's size should not be empty")
    private String modelSize;

    @NotEmpty(message = "Model's price should not be empty")
    private BigDecimal modelPrice;

    private Float modelVolume;

    @NotEmpty(message = "Model's work modes should not be empty")
    private String modelWorkModes;

    @NotEmpty(message = "Model's doors should not be empty")
    private Integer modelDoors;

    @NotEmpty(message = "Model's compressor should not be empty")
    private String modelCompressor;

    @NotEmpty(message = "Model's category should not be empty")
    private String modelCategory;

    @NotEmpty(message = "Model's processor should not be empty")
    private String modelProcessor;

    @NotEmpty(message = "Model's memory should not be empty")
    private Integer modelMemory;

    private String modelCamera;

    @NotEmpty(message = "Model's technology should not be empty")
    private String modelTechnology;

    private Boolean modelAvailability;
}
