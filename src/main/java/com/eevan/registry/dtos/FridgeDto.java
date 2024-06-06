package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
public class FridgeDto extends ProductDto {
    private Integer modelDoors;
    private String modelCompressor;
}
