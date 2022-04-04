package com.botaniac.forumsservice.controller;
import com.botaniac.forumsservice.DTO.BrowseDiscussionsDTO;
import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.enums.ForumSection;
import com.botaniac.forumsservice.service.DiscussionService;
import com.botaniac.forumsservice.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class RestForumController {
    @Autowired
    private final DiscussionService discussionService=new DiscussionService();
    private final MessageService messageService=new MessageService();
    @RequestMapping(value = "/forums/forumsSections",method = RequestMethod.GET)
    public String showSections(){
        log.info("Fetching the forum sections...");
        List<ForumSection> sections= Arrays.asList(ForumSection.values());

        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(sections);
        }catch (IOException exception){
            return "Error creating JSON for forum sections:"+ exception.getMessage();
        }
    }
    @RequestMapping(value = "/forums/sectionDiscussions",method = RequestMethod.GET)
    public Page<BrowseDiscussionsDTO> showDiscussions(@RequestParam ForumSection section, @RequestParam int page){
        log.info("Getting discussions from section "+section+" at page "+page);
        Page<BrowseDiscussionsDTO> pages=discussionService.browseDiscussions(section,page-1);
        log.info("Total pages: "+pages.getTotalPages());
        return pages;
    }
}

