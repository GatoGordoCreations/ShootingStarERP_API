package app.shootingstar.ShootingStarERP.API.Organization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="ORGANIZATION")
@Setter
@Getter
public class Organization {

    public Organization() {
        this.active = true;
    }
    @Id
    @Column(name="entity_id")
    private int id;

    @Column(name="organization_type")
    private String type;

    @Column(name="org_name")
    private String name;

    @Column(name="active")
    private boolean active;

    @Column(name="url")
    private String url;


}
