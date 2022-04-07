package com.botaniac.forumsservice.service;

import com.botaniac.forumsservice.DTO.BrowseDiscussionsDTO;
import com.botaniac.forumsservice.DTO.OriginalPostDTO;
import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.enums.ForumSection;
import com.botaniac.forumsservice.repository.DiscussionRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DiscussionService {
    @Autowired
    ModelMapper modelMapper=new ModelMapper();
    @Autowired
    DiscussionRepository discussionRepository;
    private final int MAX_DISCUSSIONS=20;

    /**
     * Finds discussions given a title
     * @param title
     * @param offset
     * @return
     */
    public List<BrowseDiscussionsDTO> findDiscussionByTitle(String title,int offset){
        Page<Discussion> entities=discussionRepository.findByTitle(title, PageRequest.of(offset,MAX_DISCUSSIONS, Sort.by("dateAdded").descending()));
        return entities.getContent().stream().map(x->modelMapper.map(x,BrowseDiscussionsDTO.class)).collect(Collectors.toList());
    }
    /**
     * Gets a chunk of 20 discussions as a list from a specified forum section
     * @param section the forum section
     * @param offset specifies the page for the query (result will start from the record with the number offset*20)
     * @return
     */
    public List<BrowseDiscussionsDTO> browseDiscussions(ForumSection section,int offset){
        Page<Discussion> entities = discussionRepository.findBySection(section, PageRequest.of(offset,MAX_DISCUSSIONS, Sort.by("dateAdded").descending()));
        return entities.getContent().stream().map(x->modelMapper.map(x,BrowseDiscussionsDTO.class)).collect(Collectors.toList());
    }

    /**
     * Gets all the discussions from a section in chunks of 20 records, while also returning useful information such as the total number of pages in the database
     * @param section
     * @return
     */
    public Page<BrowseDiscussionsDTO> browseDiscussionsByPage(ForumSection section){
        Page<Discussion> entities = discussionRepository.findBySection(section, PageRequest.of(0,MAX_DISCUSSIONS));
        Page<BrowseDiscussionsDTO> dtoPage = entities.map(obj -> {
            return modelMapper.map(obj,BrowseDiscussionsDTO.class);
        });
        return dtoPage;
    }

    /**
     * Gets discussion with specified ID as an Original Post DTO
     * @param id
     * @return
     */
    public OriginalPostDTO getOriginalPost(Long id){
        log.info("Getting the contents for discussion "+id);
        return modelMapper.map(discussionRepository.getById(id),OriginalPostDTO.class);
    }

    /**
     * Gets every database info for the discussion with the specified id
     * @param id
     * @return
     */
    public Discussion getDiscussion(Long id){
        log.info("Getting the contents for discussion "+id);
        return discussionRepository.getById(id);
    }
}
