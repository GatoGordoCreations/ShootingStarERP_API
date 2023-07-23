package app.shootingstar.ShootingStarERP.API.Phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneTypeRepository extends JpaRepository<PhoneType, String> {

    @Query(value="SELECT short_desc " +
            "FROM val_phone_type " +
            "WHERE phone_type = ?1", nativeQuery = true)
    public String getDesc(String num);
}
