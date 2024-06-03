package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TvDTO {
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
