package app.shootingstar.ShootingStarERP.API.OrganizationTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/organization/types")
@CrossOrigin("*")
public class OrganizationTypesController {

    @Autowired
    private OrganizationTypesRepository repo;

    public OrganizationTypesController(OrganizationTypesRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<OrganizationTypes> getTypes() {
        return repo.findAll();
    }
}
