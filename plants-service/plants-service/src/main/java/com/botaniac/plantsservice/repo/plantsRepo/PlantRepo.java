package com.botaniac.plantsservice.repo.plantsRepo;

import com.botaniac.plantsservice.model.entity.plants.Plant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepo extends JpaRepository<Plant,String> {
    Page<Plant> findAll(Pageable page);
}
