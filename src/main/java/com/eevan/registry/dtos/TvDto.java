package com.eevan.registry.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Schema(description = "TV DTO")
@Getter
@Setter
public class TvDto extends ProductDto {
    @Schema(description = "Category of TV")
    private String modelCategory;
    @Schema(description = "Type of technology")
    private String modelTechnology;
}
