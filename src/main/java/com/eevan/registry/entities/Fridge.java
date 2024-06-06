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
@DiscriminatorValue(value = "Fridge")
public class Fridge extends Product {

    @NotEmpty(message = "Model's doors should not be empty")
    @Column(name = "model_doors")
    private Integer modelDoors;

    @NotEmpty(message = "Model's compressor should not be empty")
    @Column(name = "model_compressor")
    private String modelCompressor;
}
