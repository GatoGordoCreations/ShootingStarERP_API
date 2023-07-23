package app.shootingstar.ShootingStarERP.Security.repository;

import app.shootingstar.ShootingStarERP.Security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
