package app.shootingstar.ShootingStarERP.API.PhoneTypes;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phonetypes")
@CrossOrigin("*")
public class PhoneTypesController {

    PhoneTypesRepository repo;

    PhoneTypesController(PhoneTypesRepository repo){
        this.repo = repo;
    }

    @GetMapping("/getall")
    public List<PhoneTypes> getAllTypes(){
        return this.repo.findAll();
    }
}
