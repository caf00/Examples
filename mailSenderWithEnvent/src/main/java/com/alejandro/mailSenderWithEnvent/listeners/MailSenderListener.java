package com.alejandro.mailSenderWithEnvent.listeners;

import com.alejandro.mailSenderWithEnvent.events.MailSenderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderListener implements ApplicationListener<MailSenderEvent> {
    private final JavaMailSender mailSender;

    @Autowired
    public MailSenderListener(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Override
    public void onApplicationEvent(MailSenderEvent event) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(event.getEmail());
        mailMessage.setSubject(event.getSubject());
        mailMessage.setFrom("alex@enterprise.com");
        mailMessage.setText(event.getMessage());
        mailSender.send(mailMessage);
    }
}
