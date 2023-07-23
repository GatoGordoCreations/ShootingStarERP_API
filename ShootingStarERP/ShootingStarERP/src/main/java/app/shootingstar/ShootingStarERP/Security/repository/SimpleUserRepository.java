package app.shootingstar.ShootingStarERP.Security.repository;

import app.shootingstar.ShootingStarERP.Security.model.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, Integer> {

    @Query(value="SELECT f_name FROM person WHERE entity_id = ?1",nativeQuery = true)
    public String getFName(Integer id);

    @Query(value="SELECT l_name FROM person WHERE entity_id = ?1",nativeQuery = true)
    public String getLName(Integer id);

    @Query(value="SELECT m_init FROM person WHERE entity_id = ?1", nativeQuery = true)
    public String getMInit(Integer id);


    @Query(value= "SELECT CASE WHEN EXISTS ( " +
            "SELECT username " +
            "FROM security_user " +
            "WHERE username = ?1) " +
            "THEN CAST(0 AS BIT) " +
            "ELSE CAST(1 AS BIT) end", nativeQuery = true)
    public boolean isUnique(String testUsername);


    @Query(value = "UPDATE security_user " +
            "SET password = ?1 " +
            "WHERE entity_id = ?2 ", nativeQuery = true)
    public SimpleUser changePassword(String password, int id);

    @Query(value = "Select password " +
            "FROM security_user " +
            "Where entity_id = ?1 ", nativeQuery = true)
    public String getHash(int hash);
}
