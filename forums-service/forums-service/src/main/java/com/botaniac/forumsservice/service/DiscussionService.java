package com.botaniac.forumsservice.service;

import com.botaniac.forumsservice.DTO.BrowseDiscussionsDTO;
import com.botaniac.forumsservice.model.enums.ForumSection;
import com.botaniac.forumsservice.repository.DiscussionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {
    private DiscussionRepository discussionRepository;
    private final int MAX_DISCUSSIONS=30;
    public List<BrowseDiscussionsDTO> browseDiscussions(ForumSection section){
        return discussionRepository.findBySection(section, PageRequest.of(0,30));
    }
    public List<BrowseDiscussionsDTO> browseDiscussions(ForumSection section,int offset){
        return discussionRepository.findBySection(section, PageRequest.of(offset,30));
    }
}
