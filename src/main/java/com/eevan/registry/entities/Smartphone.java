package com.eevan.registry.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "Smartphone")
public class Smartphone extends Product {

    @NotEmpty(message = "Model's memory should not be empty")
    @Column(name = "model_memory")
    private Integer modelMemory;

    @NotEmpty(message = "Model's memory should not be empty")
    @Column(name = "model_camera")
    private String modelCamera;
}
