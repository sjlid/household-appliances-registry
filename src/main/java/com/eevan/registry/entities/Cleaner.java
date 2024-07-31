package com.eevan.registry.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Objects;


@Entity
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "CLEANER")
public class Cleaner extends Product {


    @Column(name = "model_volume")
    private Float modelVolume;

    @NotEmpty(message = "Model's work modes should not be empty")
    @Column(name = "model_modes")
    private String modelWorkModes;

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Cleaner other = (Cleaner) obj;
        return Objects.equals(modelVolume, other.modelVolume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelVolume);
    }
}
