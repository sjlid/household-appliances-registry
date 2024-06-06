package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
public class PcDto extends ProductDto {
    private String modelCategory;
    private String modelProcessor;
}
