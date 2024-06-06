package com.eevan.registry.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "product_family")
public class ProductFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "country_manufacturer")
    private String countryManufacturer;

    @Column(name = "company_manufacturer")
    private String companyManufacturer;

    @Column(name = "buy_online")
    private Boolean isAbleToBuyOnline;

    @Column(name = "installment")
    private Boolean isAbleToInstallment;

    @Column(name = "product_type")
    private String productType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productFamily")
    private List<Product> availableProducts = new ArrayList<Product>();

}
