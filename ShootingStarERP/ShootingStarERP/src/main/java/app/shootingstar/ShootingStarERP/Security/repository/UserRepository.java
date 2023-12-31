package app.shootingstar.ShootingStarERP.Security.repository;


import app.shootingstar.ShootingStarERP.Security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String email);
}
