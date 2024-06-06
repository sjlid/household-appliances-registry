package com.eevan.registry.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "Cleaner")
public class Cleaner extends Product {

    @Column(name = "model_volume")
    private Float modelVolume;

    @NotEmpty(message = "Model's work modes should not be empty")
    @Column(name = "model_modes")
    private String modelWorkModes;
}
