package com.example.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);
    private JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Email email) {
        send(Application.COMPANY_EMAIL, email.getSender(),  email.getSubject(), email.getMessage());
    }

    public void sendNotification(String sender) {
        send(sender, Application.COMPANY_EMAIL, "Wiadomość do Otwarte Drzwi",
                "Witaj! Otrzymaliśmy twoją wiadomość. Postaramy się odpowiedzieć w " +
                        "możliwie najkrótszym czasie");
    }

    public void send(String to, String replyTo, String title, String message) {
        logger.debug("Wysyłam maila do {}", to);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(Application.COMPANY_EMAIL);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setReplyTo(replyTo);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(message);
        javaMailSender.send(simpleMailMessage);
        logger.debug("Mail do {} został wysłany", to);
    }
}
