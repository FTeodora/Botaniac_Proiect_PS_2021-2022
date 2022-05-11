package com.botaniac.plantsservice.DTO;

import com.botaniac.plantsservice.model.entity.plants.PlantRequirements;
import com.botaniac.plantsservice.model.enums.PlantType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CreatePlantDTO {
    @NotBlank
    private String scientificName;
    @NotBlank
    private String commonName;
    private String description;
    private String nativeContinent;
    private PlantType type;
    private PlantRequirements requirements;
}
