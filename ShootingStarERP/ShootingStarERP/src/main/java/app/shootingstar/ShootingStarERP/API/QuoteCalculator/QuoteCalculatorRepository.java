package app.shootingstar.ShootingStarERP.API.QuoteCalculator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteCalculatorRepository extends JpaRepository<QuoteCalculator, Integer> {


}
