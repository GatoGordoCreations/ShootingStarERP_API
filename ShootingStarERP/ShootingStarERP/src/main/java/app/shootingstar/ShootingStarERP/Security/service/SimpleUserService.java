package app.shootingstar.ShootingStarERP.Security.service;

import app.shootingstar.ShootingStarERP.Security.model.SimpleUser;
import app.shootingstar.ShootingStarERP.Security.repository.SimpleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

public class SimpleUserService {

    private SimpleUser simpleUser;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private SimpleUserRepository repo;

    private final String DEFAULT_PASSWORD = "password";

    private String fName;
    private String lName;
    private String mInit;

    public SimpleUserService(){}
    public SimpleUserService (PasswordEncoder encoder, SimpleUserRepository repo) {
        this.encoder = encoder;
        this.repo = repo;
    }

    public SimpleUser populateSimpUser(int id) {
        SimpleUser simpleUser = new SimpleUser();
        extractData(id);

        simpleUser.setEntityId(id);
        simpleUser.setUsername(createUsername());
        simpleUser.setPassword(encode(DEFAULT_PASSWORD));
        simpleUser.setFirstName(this.fName);
        simpleUser.setLastName(this.lName);

        return simpleUser;
    }

    private String createUsername(){
        String testUsername = null;
        boolean unique = false;
        int counter = 0;

        while(!unique && counter < fName.length() ) {
            if(mInit != null) {

                testUsername = this.fName.toLowerCase().charAt(counter) + this.mInit.toLowerCase() + lName.toLowerCase();
            } else {
                testUsername = this.fName.toLowerCase().charAt(counter) + lName.toLowerCase();
            }
            if(repo.isUnique(testUsername)) {unique = true; };
            counter++;
        }
        if(!unique) {
            while(!unique) {
                Random rand = new Random();
                int rNum = rand.nextInt(1000);
                String sNum = Integer.toString(rNum);
                testUsername = this.lName.toLowerCase() + sNum;

                if(repo.isUnique(testUsername)) {unique = true; };
            }
            
        }

        return testUsername;
    }
    
    private void extractData(int id) {
        this.fName = repo.getFName(id);
        this.lName = repo.getLName(id);
        this.mInit = repo.getMInit(id);

    }
    public String encode(String input) {

        return encoder.encode(input);
    }
}
