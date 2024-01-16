package com.email.send.controller;

import com.email.send.Entity.Mail;
import com.email.send.Entity.MailRequest;
import com.email.send.sevice.mailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class mailController {
    @Autowired
    private mailService mailService;

    @PostMapping("/send-mail")
    public void sendMail(@RequestBody MailRequest mailRequest) {
        // mailRequest doit contenir les informations nécessaires (destinataire, sujet, message)
        Mail mail = new Mail(mailRequest.getStructure().getSubject(), mailRequest.getStructure().getMessage());

        try {
            mailService.sendMail(mailRequest.getTo(), mail);
        } catch (Exception e) {
            // Gérer les erreurs d'envoi d'e-mail
            e.printStackTrace();
        }
    }
}
