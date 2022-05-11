package com.botaniac.emailservice.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Slf4j
@Component
public class BasicEmail {
    private String sender;
    private String recipient;
    private String contents;
    @Value("${spring.mail.port}")
    private String PORT ;
    @Value("${spring.mail.host}")
    private  String HOST ;
    @Value("${spring.mail.username}")
    private String USERNAME ;
    @Value("${spring.mail.password}")
    private String PASSWORD ;
    private String EMAIL="a80b084a80-97dc04+1@inbox.mailtrap.io";
    private final boolean AUTH = true;
    private final boolean STARTTLS = true;

    public void send(MailTemplate template) throws AddressException, MessagingException, IOException {
        Message msg = new MimeMessage(setSession(setProperties()));

        msg.setSentDate(new Date());
        msg.setSubject("Hello!");

        msg.setFrom(new InternetAddress(EMAIL, false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(template.getRecipient()));

        msg.setContent(template.generateMailBody(), "text/html");
        Transport.send(msg);
        log.info("e-mail to "+template.getRecipient()+" and template from "+template.getTemplatePath()+" sent");
    }

    private Session setSession(Properties props) {
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        return session;
    }

    private Properties setProperties() {
        Properties props = new Properties();

        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.starttls.enable", STARTTLS);
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        return props;
    }
}
