package com.example.email;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    private MailService mailService;

    public MyController(MailService mailService) {
        this.mailService = mailService;
    }

    @RequestMapping("/")
    public String home(){
        return("home");
    }

    @RequestMapping("/kontakt")
    public String kontakt(Model model) {
        model.addAttribute("email", new Email());
        return("kontakt");
    }

    @RequestMapping("/send")
    public String send(Email email) {
        mailService.sendEmail(email);
        mailService.sendNotification(email.getSender());
        return "redirect:/";
    }
}
