package com.eevan.registry.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "PC")
public class Pc extends Product {

    @NotEmpty(message = "Model's category should not be empty")
    @Column(name = "model_category")
    private String modelCategory;

    @NotEmpty(message = "Model's processor should not be empty")
    @Column(name = "model_processor")
    private String modelProcessor;

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Pc other = (Pc) obj;
        return Objects.equals(modelCategory, other.modelCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelCategory);
    }
}
