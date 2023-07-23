package app.shootingstar.ShootingStarERP.API.PersonTypes;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VAL_PERSON_TYPE")
@Setter
@Getter
public class PersonTypes {

    @Id
    @Column(name="person_type")
    private String person_type;

    @Column(name="abbr")
    private String abbr;

    @Column(name="short_desc")
    private String short_desc;

    @Column(name="long_desc")
    private String long_desc;

    @Column(name="active")
    private boolean active;
}
