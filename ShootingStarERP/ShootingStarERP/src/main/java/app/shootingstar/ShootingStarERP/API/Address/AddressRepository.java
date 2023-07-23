package app.shootingstar.ShootingStarERP.API.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {


    @Query(value="SELECT * " +
            "FROM address " +
            "WHERE entity_id = ?1 " +
            "AND active = 1", nativeQuery = true)
    public List<Address> getAllAddressByEntity_Id(int id);

    @Modifying
    @Transactional
    @Query(value="UPDATE address " +
            "SET active = 0, end_date = ?2 " +
            "WHERE id = ?1", nativeQuery = true)
    public void inactive(int recordId, Date date);
}
