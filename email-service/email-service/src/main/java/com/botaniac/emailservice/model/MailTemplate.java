package com.botaniac.emailservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailTemplate {
    private String recipient;
    private String templatePath;
    private HashMap<String ,Object> values;
    public String generateMailBody(){
        StringBuilder builder=new StringBuilder();
        try {
            InputStream resource = new ClassPathResource(
                    "mails/"+templatePath).getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(resource));
            String st;
            Pattern p = Pattern.compile("(%[A-Za-z]+%)");

            while ((st = br.readLine()) != null)
            {
                Matcher m = p.matcher(st);

                while(m.find()){
                    String substr=st.substring(m.start(),m.end());
                    String varName=substr.substring(1,substr.length()-1);
                    //System.out.println("found:"+substr+"var:"+varName);
                    st=st.replaceAll(substr,this.values.get(varName).toString());
                }
                builder.append(st).append("<br>");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
