package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "TV DTO")
@Getter
@Setter
public class TvDto extends ProductDto {
    @Schema(description = "Category of TV")
    @NotEmpty(message = "Model's category should not be empty")
    private String modelCategory;

    @Schema(description = "Type of technology")
    @NotEmpty(message = "Model's technology should not be empty")
    private String modelTechnology;
}
