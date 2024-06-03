package com.eevan.registry.dtos;

import com.eevan.registry.entities.AbstractAppliance;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CleanerDTO{
    @NotEmpty(message = "Product type should not be empty")
    private String productType;

    @NotEmpty(message = "Manufacturing country should not be empty")
    private String countryManufacturer;

    @NotEmpty(message = "Manufacturing company should not be empty")
    private String companyManufacturer;
    private boolean isAbleToBuyOnline;
    private boolean isAbleToInstallment;
    private List<Object> goodsPresenting = new ArrayList<>();
}
