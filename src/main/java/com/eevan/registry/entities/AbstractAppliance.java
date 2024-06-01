package com.eevan.registry.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@MappedSuperclass
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

    @Transient
    private List<Object> goodsPresenting = new ArrayList<>();
}
