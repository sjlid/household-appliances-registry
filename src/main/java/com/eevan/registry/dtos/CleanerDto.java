package com.eevan.registry.dtos;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Getter
@Setter
public class CleanerDto extends ProductDto{
    private Float modelVolume;
    private String modelWorkModes;
}
