package app.shootingstar.ShootingStarERP.API.Organization;




import app.shootingstar.ShootingStarERP.API.RootEntity.RootEntity;
import app.shootingstar.ShootingStarERP.API.RootEntity.RootEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("organization")
@CrossOrigin("*")
public class OrganizationController {

    @Autowired
    private OrganizationRepository repo;
    @Autowired
    private RootEntityRepository entRepo;

    public OrganizationController(OrganizationRepository repo, RootEntityRepository entRepo){
        this.repo = repo;
        this.entRepo = entRepo;
    }

    @PostMapping("/add")
    public Organization create(@RequestBody Organization org){
        //create and populate entity, return object with new id
        RootEntity ent = new RootEntity();
        ent.setEntity_type("2");
        ent = entRepo.save(ent);
        int id = ent.getEntity_id();
        // add entity_id to Organization Object and save to database
        org.setId(id);

        return repo.save(org);
    }

    @GetMapping("/get")
    public Optional<Organization> getOrg(@RequestParam int id){
        return repo.findById(id);
    }

    @GetMapping("/get/subtype")
    public String getOrgSubType(@RequestParam int id){
        return repo.getOrgSubType(id);
    }

}
