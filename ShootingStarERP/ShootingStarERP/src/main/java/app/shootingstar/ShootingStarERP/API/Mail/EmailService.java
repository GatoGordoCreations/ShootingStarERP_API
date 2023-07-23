package app.shootingstar.ShootingStarERP.API.Mail;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    JavaMailSender emailSender;

    private final String NO_REPLY = "donotreply@gatogordocreations.com";
    private final String TO = "info@gatogordocreations.com";

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    public void sendMessage(MailEntity mailEntity) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(NO_REPLY);
        message.setTo(mailEntity.getTo());
        message.setSubject(mailEntity.getSubject());
        message.setText(mailEntity.getText());

        this.emailSender.send(message);
    }

    public void sendQuoteMessage(String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(NO_REPLY);
        message.setTo(TO);
        message.setSubject("GGC: Quote Calculator");
        message.setText(text);

        this.emailSender.send(message);
    }


}
