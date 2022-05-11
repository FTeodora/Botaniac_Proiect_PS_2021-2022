package com.botaniac.accountsservice.factories;

import java.util.HashMap;

public class MailFactory {
    public static MailTemplate sendRegistrationMail(String mail, String username){
        MailTemplate m=new MailTemplate();
        m.setRecipient(mail);
        m.setValues(new HashMap<>());
        m.setTemplatePath("hello.txt");
        m.getValues().put("name",username);
        return m;
    }
}
