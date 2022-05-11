package com.botaniac.plantsservice.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ViewPlantDTO {
    private String id;
    private String commonName;
    private String scientificName;
}
