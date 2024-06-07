package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFamilyDto {
    private String familyName;
    private String countryManufacturer;
    private String companyManufacturer;
    private Boolean isAbleToBuyOnline;
    private Boolean isAbleToInstallment;
    private ProductType productType;
    private Integer availableProducts;
}
