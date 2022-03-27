package com.botaniac.plantsservice.repo.plantProgressRepo;

import com.botaniac.plantsservice.model.entity.plantProgress.PersonalPlantProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalPlantProgressRepo extends JpaRepository<PersonalPlantProgress,Long> {
}
