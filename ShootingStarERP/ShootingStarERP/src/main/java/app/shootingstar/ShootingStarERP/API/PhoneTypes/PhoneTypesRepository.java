package app.shootingstar.ShootingStarERP.API.PhoneTypes;

import app.shootingstar.ShootingStarERP.API.Phone.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneTypesRepository extends JpaRepository<PhoneTypes, String> {


}
