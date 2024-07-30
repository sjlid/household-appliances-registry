package com.eevan.registry.util;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.Product;
import com.eevan.registry.entities.ProductFamily;

public class DataUtils {

    public static ProductFamily getProductFamilyTransient() {
        return ProductFamily.builder()
                .familyName("UltraCool")
                .countryManufacturer("Russia")
                .companyManufacturer("ZiL")
                .isAbleToBuyOnline(true)
                .isAbleToInstallment(false)
                .availableProducts(0)
                .productType("FRIDGE")
                .build();
    }

    public static ProductFamily getProductFamilyPersisted() {
        return ProductFamily.builder()
                .id(1L)
                .familyName("UltraCool")
                .countryManufacturer("Russia")
                .companyManufacturer("ZiL")
                .isAbleToBuyOnline(true)
                .isAbleToInstallment(false)
                .availableProducts(0)
                .productType("FRIDGE")
                .build();
    }
}
