package app.shootingstar.ShootingStarERP.Security.controller;



import app.shootingstar.ShootingStarERP.Security.model.PasswordUpdate;
import app.shootingstar.ShootingStarERP.Security.model.SimpleUser;
import app.shootingstar.ShootingStarERP.Security.repository.SimpleUserRepository;
import app.shootingstar.ShootingStarERP.Security.service.SimpleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simpleuser")
@CrossOrigin(origins = "http://localhost:4200")
public class SimpleUserController {

    @Autowired
    private SimpleUserRepository repo;

    @Autowired
    private SimpleUserService simpService;

    SimpleUserController (SimpleUserRepository repo, SimpleUserService simpService) {
        this.repo = repo;
        this.simpService = simpService;
    }

    @PostMapping("/create")
    public SimpleUser createNewUser(@RequestParam Integer id) {

        SimpleUser simpleUser = simpService.populateSimpUser(id);


        return repo.save(simpleUser);
    }

    @PostMapping("/updatepassword")
    public String updatePassword(@RequestBody PasswordUpdate passwordUpdate) {
        String saveHash = simpService.encode(passwordUpdate.getPassword());
        System.out.println(saveHash);
        String returnString = null;
        try {
            repo.changePassword(saveHash, passwordUpdate.getId());
        } catch (Exception e) {
            String getHash = repo.getHash(passwordUpdate.getId());
            returnString = "Intended: " + getHash + "\n" + "Result:   " + saveHash + "\n" + "Save: " + getHash.equals(saveHash);

        }
        return returnString;
    }

}
