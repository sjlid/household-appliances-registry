package com.eevan.registry.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "CLEANER")
public class Cleaner extends Product {

    @NotEmpty(message = "Volume's work modes should not be empty")
    @Column(name = "model_volume")
    private Float modelVolume;

    @NotEmpty(message = "Model's work modes should not be empty")
    @Column(name = "model_modes")
    private String modelWorkModes;
}
