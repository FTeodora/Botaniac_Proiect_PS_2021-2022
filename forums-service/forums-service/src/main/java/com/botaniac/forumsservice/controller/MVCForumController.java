package com.botaniac.forumsservice.controller;

import com.botaniac.forumsservice.model.enums.ForumSection;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class MVCForumController {
    Logger logger= LoggerFactory.getLogger(MVCForumController.class);
    @GetMapping("/forums")
    public WebMvcProperties.View getSections(){
        logger.info("Getting Forum Sections page...");
        return new WebMvcProperties.View();
    }
    @GetMapping("/section")
    public ModelAndView browseSection(@RequestParam ForumSection forumSection){
        ModelAndView mav=new ModelAndView();
       // mav.setViewName(forumSection.getDisplayName());
        mav.addObject("section",forumSection.getDisplayName());
        return mav;
    }
}
