package com.botaniac.forumsservice.controller.mvc;
import com.botaniac.forumsservice.DTO.MessageDTO;
import com.botaniac.forumsservice.DTO.NewMessageDTO;
import com.botaniac.forumsservice.DTO.OriginalPostDTO;
import com.botaniac.forumsservice.model.enums.ForumSection;
import com.botaniac.forumsservice.service.DiscussionService;
import com.botaniac.forumsservice.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class MVCForumController {
    @GetMapping("/forums")
    public WebMvcProperties.View getSections(){
        log.info("Getting Forum Sections page...");
        return new WebMvcProperties.View();
    }

}
