package app.shootingstar.ShootingStarERP.API.Phone;

import app.shootingstar.ShootingStarERP.API.Address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/phone")
@CrossOrigin("*")
public class PhoneController {


    private PhoneService service;
    @Autowired
    private PhoneRepository repo;

    public PhoneController(PhoneRepository repo, PhoneService service) {
        this.repo = repo;
        this.service = service;
    }

    @PostMapping("/add")
    public Phone addPhone(@RequestBody Phone phone) {
        return this.repo.save(phone);
    }

    @PostMapping("/replace")
    public Phone replacePhone(@RequestBody Phone phone, @RequestParam int recordId) {
        return service.replacePhone(phone, recordId);
    }

    @PostMapping("/inactive")
    public void phoneInactive(@RequestBody RecordId inputBody) {
        this.repo.inactive(inputBody.getRecordId(), new Date());
    }

    @GetMapping("/getbyid")
    public List<PhoneJoin> getPhoneById(@RequestParam int id) {
        return service.getPhoneAndTypes(id); }
}
