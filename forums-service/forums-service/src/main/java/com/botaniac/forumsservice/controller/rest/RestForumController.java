package com.botaniac.forumsservice.controller.rest;
import com.botaniac.forumsservice.DTO.BrowseDiscussionsDTO;
import com.botaniac.forumsservice.DTO.MessageDTO;
import com.botaniac.forumsservice.configurations.RMQConfig;
import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.enums.ForumSection;
import com.botaniac.forumsservice.service.DiscussionService;
import com.botaniac.forumsservice.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class RestForumController {
    @Autowired
    private final DiscussionService discussionService=new DiscussionService();
    @Autowired
    private final MessageService messageService=new MessageService();
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping(value = "/forums/rabbitTest")
    public String vibeCheck(){
        rabbitTemplate.convertAndSend(RMQConfig.topicExchangeName,RMQConfig.ROUTING_KEY,"Vibe Check");
        return "Your vibe has been checked";
    }
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
    public List<BrowseDiscussionsDTO> showDiscussions(@RequestParam ForumSection section, @RequestParam int page){
        log.info("Getting discussions from section "+section+" at page "+page);
        return discussionService.browseDiscussions(section,page-1);
    }

    @RequestMapping(value = "/forums/getDiscussionMessages")
    public List<MessageDTO> getDiscussionMessages(@RequestParam Long discussionID,@RequestParam int page){
        log.info("Getting messages for discussion "+discussionID+" at page "+page);
        log.info("Getting parent discussion...");
        Discussion parent=discussionService.getDiscussion(discussionID);
        if(parent==null){
            log.error("Couldn't get parent discussion");
            return new ArrayList<>();
        }
        List<MessageDTO> res=messageService.getDiscussionMessages(parent,page-1);
        rabbitTemplate.convertAndSend(RMQConfig.topicExchangeName,RMQConfig.ROUTING_KEY,res.stream().map(m->m.getPoster()).collect(Collectors.toList()));
        log.info("Fetched "+res.size()+" results");
        return res;
    }
}

