package com.eevan.registry.entities;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class AbstractAppliance {
    private String productType;
    private String countryProducer;
    private String companyProducer;
    private boolean isAbleToBuyOnline;
    private boolean isAbleToInstallment;
    private Map<String, String> goodsPresenting = new HashMap<>();
}
