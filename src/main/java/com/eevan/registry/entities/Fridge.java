package com.eevan.registry.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Fridge")
public class Fridge extends AbstractAppliance{
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

    @NotEmpty(message = "Model's doors should not be empty")
    @Column(name = "model_doors")
    private int modelDoors;

    @NotEmpty(message = "Model's compressor should not be empty")
    @Column(name = "model_compressor")
    private String modelCompressor;

    @Column(name = "model_availability")
    private boolean modelAvailability;
}
