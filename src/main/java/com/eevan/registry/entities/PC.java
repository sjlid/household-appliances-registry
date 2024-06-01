package com.eevan.registry.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "PC")
public class PC extends AbstractAppliance{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

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
    private int modelSize;

    @NotEmpty(message = "Model's price should not be empty")
    @Column(name = "model_price")
    private BigDecimal modelPrice;

    @NotEmpty(message = "Model's category should not be empty")
    @Column(name = "model_category")
    private String modelCategory;

    @NotEmpty(message = "Model's processor should not be empty")
    @Column(name = "model_processor")
    private String modelProcessor;

    @Column(name = "model_availability")
    private boolean modelAvailability;
}
