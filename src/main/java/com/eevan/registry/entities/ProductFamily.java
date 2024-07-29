package com.eevan.registry.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotEmpty;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_family", indexes = @Index(columnList = "family_name"))
public class ProductFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Family name should not be empty")
    @Column(name = "family_name")
    private String familyName;

    @NotEmpty(message = "Country manufacturer should not be empty")
    @Column(name = "country_manufacturer")
    private String countryManufacturer;

    @NotEmpty(message = "Company manufacturer should not be empty")
    @Column(name = "company_manufacturer")
    private String companyManufacturer;

    @NotNull(message = "Possibility to buy online should not be empty")
    @Column(name = "buy_online")
    private Boolean isAbleToBuyOnline;

    @NotNull(message = "Installment payment possibility should not be empty")
    @Column(name = "installment")
    private Boolean isAbleToInstallment;

    @NotNull(message = "Product type should not be empty")
    @Column(name = "product_type")
    private String productType;

    @Column(name = "models_available")
    private Integer availableProducts;

}
