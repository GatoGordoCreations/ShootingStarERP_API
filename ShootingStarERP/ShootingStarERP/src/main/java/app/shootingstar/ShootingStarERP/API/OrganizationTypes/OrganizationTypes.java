package app.shootingstar.ShootingStarERP.API.OrganizationTypes;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VAL_ORGANIZATION_TYPE")
@Setter
@Getter
public class OrganizationTypes {

    @Id
    @Column(name="organization_type")
    private String organization_type;

    @Column(name="abbr")
    private String abbr;

    @Column(name="short_desc")
    private String short_desc;

    @Column(name="active")
    private boolean active;

    public OrganizationTypes(){
        this.active = true;
    }
}
