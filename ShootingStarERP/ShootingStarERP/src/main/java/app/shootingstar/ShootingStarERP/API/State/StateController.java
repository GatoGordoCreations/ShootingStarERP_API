package app.shootingstar.ShootingStarERP.API.State;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
@CrossOrigin("*")
public class StateController {

    StateRepository repo;

    public StateController(StateRepository repo){
        this.repo = repo;
    }

    @PostMapping
    public List<State> saveAllStates(@RequestBody List<State> states){
        return repo.saveAll(states);
    }

    @GetMapping
    public List<State> getAllStates(){
        return repo.findAll();
    }

}
