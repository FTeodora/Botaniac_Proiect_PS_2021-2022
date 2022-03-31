package com.botaniac.forumsservice.controller;

import com.botaniac.forumsservice.DTO.BrowseDiscussionsDTO;
import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.enums.ForumSection;
import com.botaniac.forumsservice.service.DiscussionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
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
    DiscussionService discussionService;
    @RequestMapping(value = "/forumsSections",method = RequestMethod.GET)
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
    @RequestMapping(value = "/sectionDiscussions",method = RequestMethod.GET)
    public String showDiscussions(@RequestParam ForumSection section){
        log.info("Fetching the "+section.getDisplayName()+" discussions...");
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(discussionService.browseDiscussions(section));
        }catch (IOException exception){
            return "Error creating JSON for discussions";
        }
    }
    @RequestMapping(value = "/sectionDiscussions",method = RequestMethod.GET)
    public String showDiscussions(@RequestParam ForumSection section,@RequestParam int page){
        log.info("Getting discussions from section "+section+" at page "+page);
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(discussionService.browseDiscussions(section,page));
        }catch (IOException exception){
            return "Error creating JSON for discussions page "+page;
        }

    }
}

