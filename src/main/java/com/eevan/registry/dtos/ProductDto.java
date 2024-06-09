package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Schema(description = "Common model DTO")
@Getter
@Setter
public class ProductDto {
    @Schema(description = "ID of necessary product family, where this model belongs to")
    private Long productFamilyId;
    @Schema(description = "Type of product")
    private ProductType productType;
    @Schema(description = "Name of model")
    private String modelName;
    @Schema(description = "serial number of model")
    private String modelSerialNumber;
    @Schema(description = "Color of model")
    private String modelColor;
    @Schema(description = "Size of model")
    private String modelSize;
    @Schema(description = "Price of model")
    private BigDecimal modelPrice;
    @Schema(description = "Availability of model")
    private Boolean modelAvailability;
}
