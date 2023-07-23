package app.shootingstar.ShootingStarERP.API.Phone;

import app.shootingstar.ShootingStarERP.Security.model.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PHONE_NUM")
@Setter
@Getter
public class Phone {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "Phone_Sequence")
    @SequenceGenerator(name = "Phone_Sequence", schema = "dbo", sequenceName = "seq_phone_num", allocationSize = 1)
    private int id;

    @Column(name="entity_id")
    private int entity_id;

    @Column(name="phone_type")
    private String phone_type;

    @Column(name="phone_num1")
    private String phone_num1;

    @Column(name="phone_num2")
    private String phone_num2;

    @Column(name="phone_num3")
    private String phone_num3;

    @Column(name="phone_ext")
    private String phone_ext;

    @Column(name="active")
    private boolean active;

    @Column(name="out_of_service")
    private boolean out_of_service;

    @Column(name="begin_date")
    private Date begin_date;

    @Column(name="end_date")
    private Date end_date;

    public Phone(){
        out_of_service = false;
        active = true;
        begin_date = new Date();
    }
}
