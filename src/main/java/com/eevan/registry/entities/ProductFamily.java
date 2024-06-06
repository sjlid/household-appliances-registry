package com.eevan.registry.entities;


import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

public class ProductFamily {
    private String familyName;
    private String countryManufacturer;
    private String companyManufacturer;
    private Boolean isAbleToBuyOnline;
    private Boolean isAbleToInstallment;
    private String productType;

    @Transient
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> availableProducts;

}
