package com.alejandro.mailSenderWithEnvent.events;

import org.springframework.context.ApplicationEvent;

public class MailSenderEvent extends ApplicationEvent {

    private final String email;
    private final String subject;
    private final String message;

    public MailSenderEvent(Object source, String email, String subject, String message) {
        super(source);
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
