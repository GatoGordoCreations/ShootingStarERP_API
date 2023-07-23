package app.shootingstar.ShootingStarERP.API.Email;


import app.shootingstar.ShootingStarERP.API.Phone.RecordId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/email")
@CrossOrigin("*")
public class EmailController {

    @Autowired
    EmailService service;

    @Autowired
    private EmailRepository repo;

    public EmailController(
            EmailRepository repo,
            EmailService service){
        this.repo = repo;
        this.service = service;
    }

    @PostMapping("/add")
    public Email addEmail(@RequestBody Email email){
        return repo.save(email);
    }

    @GetMapping("/getbyid")
    public List<Email> getEmailById(@RequestParam int id) { return repo.getAllByEntity_Id(id); }

    @PostMapping("/replace")
    public Email replaceEmail(@RequestBody Email email, @RequestParam int recordId) { return service.replaceEmail(email, recordId);
    }

    @PostMapping("/inactive")
    public void emailInactive(@RequestBody RecordId inputBody) {
        this.repo.inactive(inputBody.getRecordId(), new Date());
    }

}
