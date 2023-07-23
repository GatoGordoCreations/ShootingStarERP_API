package app.shootingstar.ShootingStarERP.API.Mail;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("email")
@CrossOrigin("*")
public class MailController {

    private final EmailService emailService;


    //Constructor//////////////////////////
    public MailController(
            EmailService emailService
    ) {
        this.emailService = emailService;
    }



    @PostMapping("/sendmessage")
    String sendEmailMessage(@RequestBody MailEntity mailEntity) {

        this.emailService.sendMessage(mailEntity
        );
        return "Message Sent";
    }
}
