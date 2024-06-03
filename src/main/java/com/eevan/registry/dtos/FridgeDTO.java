package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FridgeDTO {
    @NotEmpty(message = "Product type should not be empty")
    private String productType;

    @NotEmpty(message = "Manufacturing country should not be empty")
    private String countryManufacturer;

    @NotEmpty(message = "Manufacturing company should not be empty")
    private String companyManufacturer;
    private boolean isAbleToBuyOnline;
    private boolean isAbleToInstallment;

    @NotEmpty(message = "Model's name should not be empty")
    private String modelName;

    @NotEmpty(message = "Model's serial should not be empty")
    private String modelSerialNumber;

    @NotEmpty(message = "Model's color should not be empty")
    private String modelColor;

    @NotEmpty(message = "Model's size should not be empty")
    private int modelSize;

    @NotEmpty(message = "Model's price should not be empty")
    private BigDecimal modelPrice;

    @NotEmpty(message = "Model's doors should not be empty")
    private int modelDoors;

    @NotEmpty(message = "Model's compressor should not be empty")
    private String modelCompressor;
    private boolean modelAvailability;
}
