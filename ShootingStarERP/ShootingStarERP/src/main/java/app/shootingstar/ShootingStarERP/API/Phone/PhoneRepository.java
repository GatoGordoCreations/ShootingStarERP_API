package app.shootingstar.ShootingStarERP.API.Phone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query(value="SELECT * " +
            "FROM phone_num p " +
            "WHERE p.active = 1 " +
            "AND p.entity_id = ?1", nativeQuery = true)
    public List<Phone> getAllByEntity_ID(int id);

    @Modifying
    @Transactional
    @Query(value="UPDATE phone_num " +
            "SET active = 0, end_date = ?2 " +
            "WHERE id = ?1", nativeQuery = true)
    public void inactive(int recordId, Date date);
}
