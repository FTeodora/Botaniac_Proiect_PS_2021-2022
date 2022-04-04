package com.botaniac.forumsservice.service;

import com.botaniac.forumsservice.DTO.BrowseDiscussionsDTO;
import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.enums.ForumSection;
import com.botaniac.forumsservice.repository.DiscussionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DiscussionService {
    @Autowired
    private ModelMapper modelMapper=new ModelMapper();
    @Autowired
    private DiscussionRepository discussionRepository;
    private final int MAX_DISCUSSIONS=30;
    public Page<BrowseDiscussionsDTO> browseDiscussions(ForumSection section){
        Page<Discussion> entities = discussionRepository.findBySection(section, PageRequest.of(0,MAX_DISCUSSIONS));
        Page<BrowseDiscussionsDTO> dtoPage = entities.map(obj -> {
            return modelMapper.map(obj,BrowseDiscussionsDTO.class);
        });
        return dtoPage;
    }
    public Page<BrowseDiscussionsDTO> browseDiscussions(ForumSection section,int offset){
        Page<Discussion> entities = discussionRepository.findBySection(section, PageRequest.of(offset,MAX_DISCUSSIONS));
        Page<BrowseDiscussionsDTO> dtoPage = entities.map(obj -> {
            return modelMapper.map(obj,BrowseDiscussionsDTO.class);
        });
        return dtoPage;
    }
}
