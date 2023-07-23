package app.shootingstar.ShootingStarERP;

import app.shootingstar.ShootingStarERP.API.Address.AddressRepository;
import app.shootingstar.ShootingStarERP.API.Address.AddressService;
import app.shootingstar.ShootingStarERP.API.Email.EmailRepository;
import app.shootingstar.ShootingStarERP.API.Email.EmailService;
import app.shootingstar.ShootingStarERP.API.Person.PersonRepository;
import app.shootingstar.ShootingStarERP.API.Person.PersonService;
import app.shootingstar.ShootingStarERP.API.Phone.PhoneRepository;
import app.shootingstar.ShootingStarERP.API.Phone.PhoneService;
import app.shootingstar.ShootingStarERP.API.Phone.PhoneTypeRepository;
import app.shootingstar.ShootingStarERP.API.RootEntity.RootEntityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShootingStarErpApplication {

	public static void main(String[] args) {

		SpringApplication.run(ShootingStarErpApplication.class, args);


	}

	@Bean
	public PhoneService createPhoneServiceBean(PhoneRepository repo, PhoneTypeRepository typeRepo){
		return new PhoneService(repo, typeRepo); }

	@Bean
	public EmailService createEmailServiceBean(EmailRepository repo){
		return new EmailService(repo);	}

	@Bean
	public AddressService createAddressServiceBean(AddressRepository repo){
		return new AddressService(repo);
	}

	@Bean
	public PersonService createPersonServiceBean(PersonRepository repo, RootEntityRepository entityRepo) {
		return new PersonService(repo, entityRepo);
	}

	//@Bean public SearchService createSearchServiceBean(){
	//	return new SearchService();
	//}

}
