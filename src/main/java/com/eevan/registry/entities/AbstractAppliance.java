package com.eevan.registry.entities;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class AbstractAppliance {
    @NotEmpty(message = "Product type should not be empty")
    @Column(name = "product_type")
    private String productType;

    @NotEmpty(message = "Manufacturing country should not be empty")
    @Column(name = "country_manufacturer")
    private String countryManufacturer;

    @NotEmpty(message = "Manufacturing company should not be empty")
    @Column(name = "company_manufacturer")
    private String companyManufacturer;

    @Column(name = "online_purchase")
    private boolean isAbleToBuyOnline;

    @Column(name = "installment_payment")
    private boolean isAbleToInstallment;

    private Map<String, String> goodsPresenting = new HashMap<>();
}
