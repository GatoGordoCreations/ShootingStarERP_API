package app.shootingstar.ShootingStarERP.API.OrgHasStaff;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ORG_HAS_STAFF")
@Setter
@Getter
public class OrgHasStaff {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "OrgHasStaff_Sequence")
    @SequenceGenerator(name = "OrgHasStaff_Sequence", schema = "dbo", sequenceName = "seq_org_has_staff", allocationSize = 1)
    private int id;

    @Column(name="org_entity_id")
    private int org_entity_id;

    @Column(name="person_entity_id")
    private int person_entity_id;

    @Column(name="active")
    private boolean active;

    @Column(name="begin_date")
    private Date begin_date;

    @Column(name="end_date")
    private Date end_date;

    public OrgHasStaff(){
        active = true;
        begin_date = new Date();
    }
}
