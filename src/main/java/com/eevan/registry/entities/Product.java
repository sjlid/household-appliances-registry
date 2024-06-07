package com.eevan.registry.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Table(name = "products", schema = "public")
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", referencedColumnName = "id")
    private ProductFamily productFamily;

    @NotEmpty(message = "Product type should not be empty")
    @Column(name = "product_type")
    private String productType;

    @NotEmpty(message = "Model's name should not be empty")
    @Column(name = "model_name")
    private String modelName;

    @NotEmpty(message = "Model's serial should not be empty")
    @Column(name = "model_serial")
    private String modelSerialNumber;

    @NotEmpty(message = "Model's color should not be empty")
    @Column(name = "model_color")
    private String modelColor;

    @NotEmpty(message = "Model's size should not be empty")
    @Column(name = "model_size")
    private String modelSize;

    @NotEmpty(message = "Model's price should not be empty")
    @Column(name = "model_price")
    private BigDecimal modelPrice;

    @NotEmpty(message = "Model's availability should not be empty")
    @Column(name = "model_available")
    private Boolean modelAvailability;
}
