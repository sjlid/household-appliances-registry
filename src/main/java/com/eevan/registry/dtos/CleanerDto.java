package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Schema(description = "Cleaner DTO")
@Getter
@Setter
public class CleanerDto extends ProductDto {
    @Schema(description = "Cleaner's volume")
    @NotEmpty(message = "Volume's work modes should not be empty")
    private Float modelVolume;

    @Schema(description = "Cleaner's work modes")
    @NotEmpty(message = "Model's work modes should not be empty")
    private String modelWorkModes;
}
