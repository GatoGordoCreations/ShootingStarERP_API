package app.shootingstar.ShootingStarERP.API.OrgHasStaff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orghasstaff")
@CrossOrigin("*")
public class OrgHasStaffController {

    @Autowired
    private OrgHasStaffRepository repo;

    public OrgHasStaffController(OrgHasStaffRepository repo){
        this.repo = repo;
    }

    @PostMapping("/add")
    public OrgHasStaff addNewRelationship(@RequestBody OrgHasStaff relationship){
        return this.repo.save(relationship);
    }

}
