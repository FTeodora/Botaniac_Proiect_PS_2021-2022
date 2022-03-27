package com.botaniac.plantsservice.repo.plantsRepo;

import com.botaniac.plantsservice.model.entity.plants.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepo extends JpaRepository<Plant,String> {
}
