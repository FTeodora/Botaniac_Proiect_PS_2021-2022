package com.botaniac.forumsservice.repository;

import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.enums.ForumSection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DiscussionRepository extends JpaRepository<Discussion,Long> {
    Page<Discussion> findBySection(ForumSection section, Pageable page);
    Page<Discussion> findByTitle(String title,Pageable pageable);
}
