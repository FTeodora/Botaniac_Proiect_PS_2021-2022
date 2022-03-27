package com.botaniac.plantsservice.model.entity.plants;

import com.botaniac.plantsservice.model.entity.plantProgress.PersonalPlantProgress;
import lombok.Builder;
import com.botaniac.plantsservice.model.enums.PlantType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="plant")
@Builder
public class Plant {
    @Id
    @Column(name="plant_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @Column(nullable = false)
    private String family;
    @Column(nullable = false,unique = true)
    private String scientificName;
    @Column
    private String commonName;
    @Column
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
