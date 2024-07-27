package com.eevan.registry.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "FRIDGE")
public class Fridge extends Product {

    @NotEmpty(message = "Model's doors should not be empty")
    @Column(name = "model_doors")
    private Integer modelDoors;

    @NotEmpty(message = "Model's compressor should not be empty")
    @Column(name = "model_compressor")
    private String modelCompressor;

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Fridge other = (Fridge) obj;
        return Objects.equals(modelDoors, other.modelDoors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelDoors);
    }
}
