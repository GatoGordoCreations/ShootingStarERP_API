package app.shootingstar.ShootingStarERP.API.RootEntity;

import app.shootingstar.ShootingStarERP.API.Pricing.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RootEntityRepository extends JpaRepository<RootEntity, Integer> {
    @Query(value = "SELECT v.short_desc " +
            "FROM entity e " +
            "JOIN val_entity_type v " +
            "ON e.entity_type = v.entity_type " +
            "WHERE e.entity_id=?1",  nativeQuery = true)
    public String getEntityVal(int num);
}
