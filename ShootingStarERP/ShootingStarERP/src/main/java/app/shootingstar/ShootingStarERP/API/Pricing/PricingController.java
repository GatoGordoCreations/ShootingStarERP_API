package app.shootingstar.ShootingStarERP.API.Pricing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pricing")
@CrossOrigin("*")
public class PricingController {

    @Autowired
    private PricingRepository repo;

    PricingController(PricingRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Pricing create(@RequestBody Pricing pricing) {
        return repo.save(pricing);
    }

    @GetMapping
    public Pricing getCurrent() {
        return repo.getCurrent();
    }
}

