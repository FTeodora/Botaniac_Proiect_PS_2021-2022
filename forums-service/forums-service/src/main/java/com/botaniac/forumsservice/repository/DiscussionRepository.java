package com.botaniac.forumsservice.repository;

import com.botaniac.forumsservice.model.entity.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion,Long> {
}
