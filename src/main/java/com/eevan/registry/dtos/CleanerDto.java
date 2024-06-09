package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Schema(description = "Cleaner DTO")
@Getter
@Setter
public class CleanerDto extends ProductDto {
    @Schema(description = "Cleaner's volume")
    private Float modelVolume;
    @Schema(description = "Cleaner's work modes")
    private String modelWorkModes;
}
