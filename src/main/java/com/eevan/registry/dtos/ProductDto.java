package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {

    private Long productFamilyId;
    private ProductType productType;
    private String modelName;
    private String modelSerialNumber;
    private String modelColor;
    private String modelSize;
    private BigDecimal modelPrice;
    private Boolean modelAvailability;
}
