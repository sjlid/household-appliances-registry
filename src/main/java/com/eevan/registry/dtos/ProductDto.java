package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {

    private Long productFamilyId;

    @NotEmpty(message = "Product type should not be empty")
    private ProductType productType;

    @NotEmpty(message = "Model's name should not be empty")
    private String modelName;

    @NotEmpty(message = "Model's serial should not be empty")
    private String modelSerialNumber;

    @NotEmpty(message = "Model's color should not be empty")
    private String modelColor;

    @NotEmpty(message = "Model's size should not be empty")
    private String modelSize;

    private BigDecimal modelPrice;
    private Boolean modelAvailability;
}
