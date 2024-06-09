package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Schema(description = "PC DTO")
@Getter
@Setter
public class PcDto extends ProductDto {
    @Schema(description = "Category of PC")
    private String modelCategory;
    @Schema(description = "Type of processor")
    private String modelProcessor;
}
