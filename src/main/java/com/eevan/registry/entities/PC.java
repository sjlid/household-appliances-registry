package com.eevan.registry.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "PC")
public class PC extends Product {

    @NotEmpty(message = "Model's category should not be empty")
    @Column(name = "model_category")
    private String modelCategory;

    @NotEmpty(message = "Model's processor should not be empty")
    @Column(name = "model_processor")
    private String modelProcessor;
}
