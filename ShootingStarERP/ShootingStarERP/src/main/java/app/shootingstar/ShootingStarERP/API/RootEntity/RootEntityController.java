package app.shootingstar.ShootingStarERP.API.RootEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("entity")
@CrossOrigin(origins = "http://localhost:4200")
public class RootEntityController {

    @Autowired
    private RootEntityRepository repo;

    RootEntityController(RootEntityRepository repository) {
        this.repo = repository;
    }

    @GetMapping("/val")
    public String getEntityVal(@RequestParam int id){
        return repo.getEntityVal(id);
    }


}
