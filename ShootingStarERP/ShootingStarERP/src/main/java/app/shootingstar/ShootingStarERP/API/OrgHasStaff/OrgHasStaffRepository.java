package app.shootingstar.ShootingStarERP.API.OrgHasStaff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgHasStaffRepository extends JpaRepository<OrgHasStaff, Integer> {
}
