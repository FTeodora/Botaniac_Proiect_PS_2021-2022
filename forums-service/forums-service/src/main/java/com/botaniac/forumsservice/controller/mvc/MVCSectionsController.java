package com.botaniac.forumsservice.controller.mvc;

import com.botaniac.forumsservice.model.enums.ForumSection;
import com.botaniac.forumsservice.service.DiscussionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class MVCSectionsController {
    @Autowired
    private DiscussionService discussionService=new DiscussionService();
    @GetMapping("/forums/section")
    public ModelAndView browseSection(@RequestParam ForumSection forumSection){
        log.info("Fetching "+forumSection+" section page... ");
        ModelAndView mav=new ModelAndView();
        mav.addObject("section",forumSection.getDisplayName());
        mav.addObject("sectionType",forumSection.toString());
        int totalPages=discussionService.browseDiscussionsByPage(forumSection).getTotalPages();
        log.info("Total pages: "+totalPages);
        mav.addObject("totalPages",totalPages);
        return mav;
    }
}
