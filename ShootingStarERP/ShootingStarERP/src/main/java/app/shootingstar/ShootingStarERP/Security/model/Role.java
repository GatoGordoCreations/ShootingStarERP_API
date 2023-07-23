package app.shootingstar.ShootingStarERP.Security.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VAL_USER_ROLE")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Role {

    @Id
    @Column(name="role_id")
    private String role_id;

    @Column(name="role_name")
    private String role_name;

}