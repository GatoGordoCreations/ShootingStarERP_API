package app.shootingstar.ShootingStarERP.Security.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SECURITY_USER")
@Setter
@Getter
public class SimpleUser {

    @Id
    @Column(name="entity_id")
    private int entityId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="f_name")
    private String firstName;

    @Column(name="l_name")
    private String lastName;

    @Column(name="default_password")
    private boolean default_password;

    @Override
    public String toString() {
        return "\n" +
                "Id: " + entityId + "\n" +
                "Username: " + username + "\n" +
                "Password(BCrypt): " + password + "\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n";
    }

    public SimpleUser(){
        default_password = true;
    }
}
