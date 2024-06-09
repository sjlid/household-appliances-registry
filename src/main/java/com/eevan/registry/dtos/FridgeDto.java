package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Schema(description = "Fridge DTO")
@Getter
@Setter
public class FridgeDto extends ProductDto {
    @Schema(description = "Quantity of doors")
    private Integer modelDoors;
    @Schema(description = "Type of compressor")
    private String modelCompressor;
}
