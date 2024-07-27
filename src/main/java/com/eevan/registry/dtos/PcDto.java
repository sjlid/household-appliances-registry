package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "PC DTO")
@Getter
@Setter
public class PcDto extends ProductDto {
    @Schema(description = "Category of PC")
    @NotEmpty(message = "Model's category should not be empty")
    private String modelCategory;

    @Schema(description = "Type of processor")
    @NotEmpty(message = "Model's processor should not be empty")
    private String modelProcessor;
}
