package app.shootingstar.ShootingStarERP.API.Email;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Email")
@Setter
@Getter
public class Email {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "Email_Sequence")
    @SequenceGenerator(name = "Email_Sequence", schema = "dbo", sequenceName = "seq_email", allocationSize = 1)
    private int id;

    @Column(name="entity_id")
    private int entity_id;

    @Column(name="email_addr")
    private String email_addr;

    @Column(name="failed")
    private boolean failed;

    @Column(name="active")
    private boolean active;

    @Column(name="begin_date")
    private Date begin_date;

    @Column(name="end_date")
    private Date end_date;

    public Email(){
        this.failed = false;
        this.active = true;
        this.begin_date = new Date();
    }
}
