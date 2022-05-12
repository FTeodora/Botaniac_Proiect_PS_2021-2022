package com.botaniac.plantsservice.DTO;

import com.botaniac.plantsservice.model.entity.plants.Plant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class NewPlantsListResponseDTO {
    private String message;
    List<CreatePlantDTO> generated;
}
