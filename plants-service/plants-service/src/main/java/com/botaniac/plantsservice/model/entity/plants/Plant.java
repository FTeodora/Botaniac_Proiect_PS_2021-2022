package com.botaniac.plantsservice.model.entity.plants;

import com.botaniac.plantsservice.model.entity.plantProgress.PersonalPlantProgress;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import com.botaniac.plantsservice.model.enums.PlantType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name="plant")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Plant {
    @Id
    @Column(name="plant_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @Column(nullable = false,unique = true)
    private String scientificName;
    @Column
    private String commonName;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private String nativeContinent;
    @Column(nullable = false)
    private PlantType type;
    @OneToOne(mappedBy = "plant",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private PlantRequirements requirements;
    @OneToMany(mappedBy = "plant",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<PersonalPlantProgress> personalPlantProgressList;


}
