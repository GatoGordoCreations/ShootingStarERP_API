package app.shootingstar.ShootingStarERP.API.State;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VAL_STATE")
@Setter
@Getter
public class State {

    @Id
    @Column(name="abbreviation")
    private String abbreviation;

    @Column(name="name")
    private String name;
}
