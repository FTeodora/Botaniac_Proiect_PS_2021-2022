package com.botaniac.plantsservice.repo.plantsRepo;

import com.botaniac.plantsservice.model.entity.plants.PlantRequirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRequirementsRepo extends JpaRepository<PlantRequirements,Long> {
}
