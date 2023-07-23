package app.shootingstar.ShootingStarERP.API.Person;

import app.shootingstar.ShootingStarERP.API.PersonTypes.PersonTypes;
import app.shootingstar.ShootingStarERP.API.PersonTypes.PersonTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private PersonTypesRepository typesRepo;

    @Autowired
    private PersonService service;

    @Autowired
    private PersonRepository repo;

    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person){
        return repo.save(person);
    }

    @PostMapping("/addnew")
    public Person addNewPerson(@RequestBody Person person) {
        return service.createNewPerson(person);
    }

    @GetMapping("/getalltypes")
    public List<PersonTypes> getAllTypes() { return typesRepo.findAll(); }

    @GetMapping("/get")
    public Optional<Person> getPerson(@RequestParam int id){
        return repo.findById(id);
    }

    @GetMapping("/get/subtype")
    public String getPersonSubType(@RequestParam int id){
        return repo.getPersonSubType(id);
    }

}
