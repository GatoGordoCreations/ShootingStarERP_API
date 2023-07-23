package app.shootingstar.ShootingStarERP.API.Email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {

    @Query(value="Select * " +
            "FROM email " +
            "WHERE entity_id = ?1 " +
            "AND active = 1", nativeQuery = true)
    public List<Email> getAllByEntity_Id(int id);

    @Modifying
    @Transactional
    @Query(value="UPDATE email " +
            "SET active = 0, end_date = ?2 " +
            "WHERE id = ?1", nativeQuery = true)
    public void inactive(int recordId, Date date);
}
