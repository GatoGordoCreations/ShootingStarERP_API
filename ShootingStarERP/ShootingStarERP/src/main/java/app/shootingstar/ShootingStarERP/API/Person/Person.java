package app.shootingstar.ShootingStarERP.API.Person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
@Setter
@Getter
public class Person {

    public Person() {
        this.active = true;
    }

    @Id
    @Column(name="entity_id")
    private int id;

    @Column(name="person_type")
    private String type;

    @Column(name="f_name")
    private String fName;

    @Column(name="m_init")
    private char mInit;

    @Column(name="l_name")
    private String lName;

    @Column(name="active")
    private boolean active;




}
