package app.shootingstar.ShootingStarERP.API.Phone;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.amqp.RabbitRetryTemplateCustomizer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VAL_PHONE_TYPE")
@Setter
@Getter
public class PhoneType {

    @Id
    @Column(name="phone_type")
    private String phone_type;

    @Column(name="abbr")
    private String abbr;

    @Column(name="short_desc")
    private String short_desc;

    @Column(name="active")
    private boolean active;
}
