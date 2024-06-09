package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "Product family DTO for response")
@Getter
@Setter
public class ProductFamilyResponseDto {
    @Schema(description = "Setted ID for this family")
    private long id;
    @Schema(description = "Name of product family")
    private String familyName;
    @Schema(description = "Name of manufacturer country")
    private String countryManufacturer;
    @Schema(description = "Name of manufacturer company family")
    private String companyManufacturer;
    @Schema(description = "Possibility to buy online")
    private Boolean isAbleToBuyOnline;
    @Schema(description = "Possibility of installment payment")
    private Boolean isAbleToInstallment;
    @Schema(description = "Type of product")
    private String productType;
}
