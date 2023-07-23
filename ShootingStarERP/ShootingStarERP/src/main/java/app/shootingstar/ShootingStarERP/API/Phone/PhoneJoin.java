package app.shootingstar.ShootingStarERP.API.Phone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhoneJoin implements Serializable {

    private int id;
    private String phone_type;
    private int entity_id;
    private String short_desc;
    private String phone_num1;
    private String phone_num2;
    private String phone_num3;
    private String phone_ext;
    private boolean out_of_service;
}
