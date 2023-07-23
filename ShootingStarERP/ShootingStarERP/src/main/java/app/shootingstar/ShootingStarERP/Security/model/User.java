package app.shootingstar.ShootingStarERP.Security.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name= "SECURITY_USER")

public class User implements UserDetails{

    public User(){} // Default Constructor

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

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


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
