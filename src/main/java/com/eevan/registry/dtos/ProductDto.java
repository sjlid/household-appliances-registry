package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Schema(description = "Common model DTO")
@Getter
@Setter
public class ProductDto {
    @Schema(description = "ID of necessary product family, where this model belongs to")
    private Long productFamilyId;

    @Schema(description = "Type of product")
    @NotEmpty(message = "Product type should not be empty")
    private ProductType productType;

    @Schema(description = "Name of model")
    @NotEmpty(message = "Model's name should not be empty")
    private String modelName;

    @Schema(description = "serial number of model")
    @NotEmpty(message = "Model's serial should not be empty")
    private String modelSerialNumber;

    @Schema(description = "Color of model")
    @NotEmpty(message = "Model's color should not be empty")
    private String modelColor;

    @Schema(description = "Size of model")
    @NotEmpty(message = "Model's size should not be empty")
    private String modelSize;

    @Schema(description = "Price of model")
    @NotEmpty(message = "Model's price should not be empty")
    private BigDecimal modelPrice;

    @Schema(description = "Availability of model")
    @NotEmpty(message = "Model's availability should not be empty")
    private Boolean modelAvailability;
}
