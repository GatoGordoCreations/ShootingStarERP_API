package app.shootingstar.ShootingStarERP.API.Pricing;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity

@Table(name="Pricing")
@Setter
@Getter
public class Pricing {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "Pricing_Sequence")
    @SequenceGenerator(name = "Pricing_Sequence", schema = "dbo", sequenceName="seq_pricing", allocationSize = 1)
    private int id;

    @Column(name="first_shooter")
    private int first_shooter;

    @Column(name="second_shooter")
    private int second_shooter;

    @Column(name="first_videographer")
    private int first_videographer;

    @Column(name="second_videographer")
    private int second_videographer;

    @Column(name="editor")
    private int editor;

    @Column(name="photobooth")
    private int photobooth;

    @Column(name="company_p")
    private float company_p;

    @Column(name="tax_rate")
    private float tax_rate;

    @Column(name="created")
    private Date created;

    public Pricing() { //Constructor
        this.created = Calendar.getInstance().getTime();
    }



}
