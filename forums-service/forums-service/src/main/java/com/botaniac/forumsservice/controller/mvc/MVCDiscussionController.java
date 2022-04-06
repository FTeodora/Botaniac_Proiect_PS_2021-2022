package com.botaniac.forumsservice.controller.mvc;

import com.botaniac.forumsservice.DTO.MessageDTO;
import com.botaniac.forumsservice.DTO.NewMessageDTO;
import com.botaniac.forumsservice.DTO.OriginalPostDTO;
import com.botaniac.forumsservice.service.DiscussionService;
import com.botaniac.forumsservice.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Slf4j
@Controller
public class MVCDiscussionController {
    @Autowired
    private DiscussionService discussionService=new DiscussionService();
    @Autowired
    private final MessageService messageService=new MessageService();
    @RequestMapping(value = "forums/discussion",method = RequestMethod.GET,params = "discussionID")
    public ModelAndView getDiscussionMessages(@RequestParam Long discussionID){
        log.info("Fetching the discussion page for discussion "+discussionID);
        ModelAndView mav=new ModelAndView();
        OriginalPostDTO discussion=discussionService.getOriginalPost(discussionID);
        if(discussion!=null)
        {
            log.info("Found discussion "+discussionID);
            Page<MessageDTO> message=messageService.getDiscussionMessagesByPage(discussionID,0);
            mav.addObject("discussion",discussion);
            mav.addObject("totalPages",message.getTotalPages());
            mav.addObject("messages",message.getContent());
            mav.addObject("newMessage",new NewMessageDTO());
        }
        else{
            log.error("Couldn't find discussion "+discussionID);
        }
        return mav;
    }
    @RequestMapping(value = "forums/discussion",method = RequestMethod.POST,params = "discussionID")
    public String getDiscussionMessages(@RequestParam Long discussionID,
                                        @Valid @ModelAttribute("newMessage") NewMessageDTO newMessage,
                                        BindingResult result){
        log.info("Checking message "+newMessage.getContent()+" posted in topic "+discussionID);
        if(!result.hasErrors())
        {
            log.info("Message has no errors. Posting...");
            messageService.postNewMessage(discussionID,newMessage);
        }
        else{
            log.error("Couldn't post message "+newMessage.getContent());
        }
        return "forums/discussion?discussionID="+discussionID;
    }
}
