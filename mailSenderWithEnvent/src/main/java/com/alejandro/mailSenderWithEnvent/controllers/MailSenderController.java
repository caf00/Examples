package com.alejandro.mailSenderWithEnvent.controllers;

import com.alejandro.mailSenderWithEnvent.dtos.MailDto;
import com.alejandro.mailSenderWithEnvent.publishers.MailSenderPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailSenderController {

    private final MailSenderPublisher publisher;

    @Autowired
    public MailSenderController(MailSenderPublisher publisher) {
        this.publisher = publisher;
    }


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("emailDto", new MailDto());
        return "index";
    }

    @PostMapping("/send")
    @ResponseBody
    public String sendMail(@ModelAttribute MailDto emailDto) {
        publisher.publish(
                emailDto.getEmail(),
                emailDto.getSubject(),
                emailDto.getMessage()
        );
        return emailDto.getEmail()+", "+emailDto.getSubject()+", "+emailDto.getMessage();
    }
}
