package com.botaniac.plantsservice.repo.documentRepo;

import com.botaniac.plantsservice.model.entity.document.PlantDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantDocumentRepo extends JpaRepository<PlantDocument,String> {
}
