package com.eevan.registry.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "Cleaner")
public class Cleaner extends AbstractAppliance{

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

    @Column(name = "model_volume")
    private Float modelVolume;

    @NotEmpty(message = "Model's work modes should not be empty")
    @Column(name = "model_modes")
    private String modelWorkModes;

    @Column(name = "model_availability")
    private Boolean modelAvailability;


}
