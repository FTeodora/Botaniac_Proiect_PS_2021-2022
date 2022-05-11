package com.botaniac.emailservice.controller;

import com.botaniac.emailservice.model.BasicEmail;
import com.botaniac.emailservice.model.MailTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;

@Slf4j
@RestController
public class EmailController {
    @Autowired
    private BasicEmail basicEmail=new BasicEmail();
    @RequestMapping("/mail")
    public ResponseEntity<String> sendEmail(){
        log.info("Reached e-mail...");
        try{
            log.info("Sending e-mail...");
            MailTemplate mt=new MailTemplate("swag.vodka@gmail.com","test.txt",new HashMap<>());
            basicEmail.send(mt);
            log.info("E-mail sent...");
        } catch (MessagingException | IOException e) {
            log.info("Error sending e-mail...");
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body("E-mail sent");
    }
}
