package app.shootingstar.ShootingStarERP.API.Address;

import app.shootingstar.ShootingStarERP.API.Phone.RecordId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin("*")
public class AddressController {

    @Autowired
    private AddressService service;

    @Autowired
    private AddressRepository repo;

    public AddressController(AddressRepository repo){
        this.repo = repo;
    }

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address){
        return repo.save(address);
    }

    @PostMapping("/replace")
    public Address replaceAddress(@RequestBody Address address, @RequestParam int recordId){
        return service.replaceAddress(address, recordId);
    }

    @PostMapping("/inactive")
    public void addressInactive(@RequestBody RecordId inputBody){
        this.repo.inactive(inputBody.getRecordId(), new Date());
    }

    @GetMapping("/getbyid")
    public List<Address> getAddressByEntity_id(@RequestParam int id) { return repo.getAllAddressByEntity_Id(id); }
}
