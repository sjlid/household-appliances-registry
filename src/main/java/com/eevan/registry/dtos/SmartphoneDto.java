package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Smartphone DTO")
@Getter
@Setter
public class SmartphoneDto extends ProductDto {
    @Schema(description = "Memory volume")
    @NotEmpty(message = "Model's memory should not be empty")
    private Integer modelMemory;

    @Schema(description = "Type of camera")
    @NotEmpty(message = "Model's memory should not be empty")
    private String modelCamera;
}
