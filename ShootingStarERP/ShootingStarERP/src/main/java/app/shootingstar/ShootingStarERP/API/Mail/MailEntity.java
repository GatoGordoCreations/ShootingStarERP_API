package app.shootingstar.ShootingStarERP.API.Mail;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
public class MailEntity {

    String to;

    String subject;

    String text;
}
