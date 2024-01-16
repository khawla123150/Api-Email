package com.email.send.sevice;

import com.email.send.Entity.Mail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Service
public class mailService {
    @Autowired
    JavaMailSender mailSender;
    @Value("$(spring.mail.username)")
    private String fromMail;


    public void sendMail(String to, Mail structure) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(fromMail);
        helper.setTo(to);
        helper.setSubject(structure.getSubject());
        helper.setText(buildHtmlContent(), true);

        mailSender.send(mimeMessage);
    }

    private String buildHtmlContent() {
        // Personnalisez votre contenu HTML ici
        return "<!DOCTYPE html>\n" +
                "<html lang=\"fr\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Remerciements pour votre inscription</title>\n" +
                "</head>\n" +
                "<body style=\"font-family: Arial, sans-serif;\">\n" +
                "\n" +
                "    <div style=\"max-width: 600px; margin: 20px auto;\">\n" +
                "        <h2>Merci de vous être inscrit sur notre site !</h2>\n" +
                "        <p>Nous sommes ravis de vous accueillir dans notre communauté.</p>\n" +
                "        \n" +
                "        <p>Pour compléter votre inscription, veuillez cliquer sur le lien ci-dessous :</p>\n" +
                "        \n" +
                "        <a href=\"https://www.votresite.com/continuer-inscription\" style=\"display: block; margin-top: 15px; padding: 10px 15px; background-color: #3498db; color: #fff; text-decoration: none; text-align: center; border-radius: 5px;\">Continuer l'inscription</a>\n" +
                "        \n" +
                "        <p>Si le lien ne fonctionne pas, vous pouvez le copier-coller dans la barre d'adresse de votre navigateur.</p>\n" +
                "        \n" +
                "        <p>Merci encore et à bientôt sur notre site !</p>\n" +
                "    </div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}
