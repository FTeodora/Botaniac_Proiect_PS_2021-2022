package com.botaniac.plantsservice.model.entity.plants;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name="plant_requirements")
@Builder
public class PlantRequirements {
    @Id
    @Column(name = "requirements_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long requirementsId;
    @OneToOne
    @JoinColumn(name="plant_id",referencedColumnName = "plant_id")
    private Plant plant;
    @Column
    private float wateringRequirementLiters;
    @Column
    private int wateringDays;
    @Column
    private int minTemperatureCelsius;
    @Column
    private int maxTemperatureCelsius;
    @Column
    private String soil;
    @Column
    private String climate;
}
