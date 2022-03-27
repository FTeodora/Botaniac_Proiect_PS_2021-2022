package com.botaniac.plantsservice.repo.plantProgressRepo;

import com.botaniac.plantsservice.model.entity.plantProgress.ProgressStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgressStepRepo extends JpaRepository<ProgressStep,Long> {
}
