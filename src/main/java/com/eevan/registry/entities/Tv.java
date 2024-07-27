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
@DiscriminatorValue(value = "TV")
public class Tv extends Product {

    @NotEmpty(message = "Model's category should not be empty")
    @Column(name = "model_category")
    private String modelCategory;

    @NotEmpty(message = "Model's technology should not be empty")
    @Column(name = "model_technology")
    private String modelTechnology;

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Tv other = (Tv) obj;
        return Objects.equals(modelTechnology, other.modelTechnology);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelTechnology);
    }
}
