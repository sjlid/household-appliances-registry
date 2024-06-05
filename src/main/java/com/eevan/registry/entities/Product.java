package com.eevan.registry.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Appliance_type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "appliance")
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    private Boolean isAbleToBuyOnline;

    @Column(name = "installment_payment")
    private Boolean isAbleToInstallment;

    @Transient
    private ProductFamily productFamily;
}
