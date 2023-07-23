package app.shootingstar.ShootingStarERP.API.Person;

import app.shootingstar.ShootingStarERP.API.RootEntity.RootEntity;
import app.shootingstar.ShootingStarERP.API.RootEntity.RootEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {

    @Autowired
    private PersonRepository repo;

    @Autowired
    private RootEntityRepository entityRepo;

    public PersonService(
            PersonRepository repo,
            RootEntityRepository entityRepo){
        this.repo = repo;
        this.entityRepo = entityRepo;
    }

    public Person createNewPerson(Person person){
        RootEntity ent = new RootEntity();
        ent.setEntity_type("1");
        ent = entityRepo.save(ent);
        int id = ent.getEntity_id();

        person.setId(id);

        if((int)person.getMInit()>=65 || (int)person.getMInit()<=90){
            person.setMInit(Character.toUpperCase(person.getMInit()));
        } else person.setMInit('\u0000');

        return repo.save(person);

    }


}
