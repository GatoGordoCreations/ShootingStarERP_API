package app.shootingstar.ShootingStarERP.API.Email;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class EmailService {

    @Autowired
    EmailRepository repo;

    public EmailService(){}

    public EmailService(EmailRepository repo){
        this.repo = repo;
    }

    public Email replaceEmail(Email email, int recordId){
        repo.inactive(recordId, new Date());
        return repo.save(email);
    }

}
