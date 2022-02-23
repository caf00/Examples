package com.alejandro.mailSenderWithEnvent.publishers;

import com.alejandro.mailSenderWithEnvent.events.MailSenderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MailSenderPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public MailSenderPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(String email, String subject, String message) {
        MailSenderEvent mailSenderEvent = new MailSenderEvent(this, email, subject, message);
        applicationEventPublisher.publishEvent(mailSenderEvent);
    }
}
