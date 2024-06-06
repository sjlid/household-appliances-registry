package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductFamilyResponseDto {
    private long id;
    private String familyName;
    private String countryManufacturer;
    private String companyManufacturer;
    private Boolean isAbleToBuyOnline;
    private Boolean isAbleToInstallment;
    private String productType;
}
