package app.shootingstar.ShootingStarERP.Security.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleUserRequest {

    private int id;

    private String username;

    private String password;
}
