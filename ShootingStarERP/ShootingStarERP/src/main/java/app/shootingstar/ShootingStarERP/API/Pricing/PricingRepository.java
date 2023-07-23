package app.shootingstar.ShootingStarERP.API.Pricing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Integer> {

    @Query(value = "SELECT * FROM pricing WHERE created=(" +
            "SELECT MAX(created) FROM pricing)",  nativeQuery = true)
    public Pricing getCurrent();
}
