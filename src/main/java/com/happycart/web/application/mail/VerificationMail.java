package com.happycart.web.application.mail;

import com.happycart.web.application.util.Env;
import io.rocketbase.mail.model.HtmlTextEmail;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;

public class VerificationMail extends Mailable{
    private String to;
    private String verificationCode;
    public VerificationMail(String to, String verificationCode){
        this.to=to;
        this.verificationCode= verificationCode;
    }
    @Override
    public void build(Message message) throws MessagingException {
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Please Confirm Your Email to HappyCart");

        String appUrl = Env.get("app_url");
        String verifyUrl = appUrl+"/verify?token="+verificationCode;

        // generate html/text content
        HtmlTextEmail content = getEmailTemplateBuilder()
                .header()
                .logo("https://www.rocketbase.io/img/logo-dark.png").logoHeight(41)
                .and()
                .text("Welcome").h1().center().and()
                .text(" To verify your email address click on the button below").center().and()
                .text(" if you did not make this request, then you can ignore this email").center().and()
                .button("Verify your email", verifyUrl).blue().and()
                .text("if you have a problem. please past this link in browser").center().and()
                .html("<a href=\""+verifyUrl+"\">"+verifyUrl+"</a>").and()
                .copyright(appUrl).url(appUrl).suffix(". All rights reserved.").and()
                .build();

// sent email
        message.setContent(content.getHtml(), "text/html");


    }
}
