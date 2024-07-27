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
@DiscriminatorValue(value = "SMARTPHONE")
public class Smartphone extends Product {

    @NotEmpty(message = "Model's memory should not be empty")
    @Column(name = "model_memory")
    private Integer modelMemory;

    @NotEmpty(message = "Model's memory should not be empty")
    @Column(name = "model_camera")
    private String modelCamera;

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Smartphone other = (Smartphone) obj;
        return Objects.equals(modelMemory, other.modelMemory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelMemory);
    }
}
