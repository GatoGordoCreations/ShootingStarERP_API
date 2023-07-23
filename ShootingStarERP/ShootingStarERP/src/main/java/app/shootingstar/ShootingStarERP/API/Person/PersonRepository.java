package app.shootingstar.ShootingStarERP.API.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value="SELECT short_desc " +
            "FROM person p " +
            "JOIN val_person_type v " +
            "ON p.person_Type = v.person_type " +
            "WHERE p.entity_id = ?1", nativeQuery = true)
    public String getPersonSubType(int id);
}
