package app.shootingstar.ShootingStarERP.Security.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class AuthRequest {


    private String username;


    private String password;
}
