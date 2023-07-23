package app.shootingstar.ShootingStarERP.API.RootEntity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="ENTITY")
@Data
public class RootEntity {

    @Id
    @Column(name="entity_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "RootEntity_Sequence")
    @SequenceGenerator(name = "RootEntity_Sequence", schema = "dbo", sequenceName = "seq_entity_id", allocationSize = 1)
    private int entity_id;
    @Column(name="entity_type")
    private String entity_type;


    public int getEntity_id() {
        return entity_id;
    }

    public String getEntity_type() {
        return entity_type;
    }

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    public void setEntity_type(String entity_type) {
        this.entity_type = entity_type;
    }


}
