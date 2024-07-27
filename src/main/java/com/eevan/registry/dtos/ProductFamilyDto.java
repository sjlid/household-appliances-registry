package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Schema(description = "Common family product DTO")
@Getter
@Setter
public class ProductFamilyDto {
    @NotEmpty(message = "Family name should not be empty")
    @Schema(description = "Name of product family")
    private String familyName;

    @NotEmpty(message = "Country manufacturer should not be empty")
    @Schema(description = "Name of manufacturer country")
    private String countryManufacturer;

    @NotEmpty(message = "Company manufacturer should not be empty")
    @Schema(description = "Name of manufacturer company family")
    private String companyManufacturer;

    @NotNull(message = "Possibility to buy online should not be empty")
    @Schema(description = "Possibility to buy online")
    private Boolean isAbleToBuyOnline;

    @NotNull(message = "Installment payment possibility should not be empty")
    @Schema(description = "Possibility of installment payment")
    private Boolean isAbleToInstallment;

    @NotNull(message = "Product type should not be empty")
    @Schema(description = "Type of product")
    private ProductType productType;
}
