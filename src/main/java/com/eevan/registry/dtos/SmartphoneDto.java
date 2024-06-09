package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Schema(description = "Smartphone DTO")
@Getter
@Setter
public class SmartphoneDto extends ProductDto {
    @Schema(description = "Memory volume")
    private Integer modelMemory;
    @Schema(description = "Type of camera")
    private String modelCamera;
}
