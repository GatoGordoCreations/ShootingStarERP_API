package app.shootingstar.ShootingStarERP.API.Address;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="ADDRESS")
@Setter
@Getter
public class Address {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "Address_Sequence")
    @SequenceGenerator(name = "Address_Sequence", schema = "dbo", sequenceName = "seq_address", allocationSize = 1)
    private int id;

    @Column(name="entity_id")
    private int entity_id;

    @Column(name="address1")
    private String address1;

    @Column(name="address2")
    private String address2;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="zipcode")
    private String zipcode;

    @Column(name="unreachable")
    private boolean unreachable;

    @Column(name="active")
    private boolean active;

    @Column(name="begin_date")
    private Date begin_date;

    @Column(name="end_date")
    private Date end_date;

    private Address(){
        unreachable = false;
        active = true;
        begin_date = new Date();
    }
}
