package app.shootingstar.ShootingStarERP.API.Organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    @Query(value="SELECT short_desc " +
            "FROM organization o " +
            "JOIN val_organization_type v " +
            "ON o.organization_type = v.organization_Type " +
            "WHERE o.entity_id = ?1", nativeQuery = true)
    public String getOrgSubType(int id);
}
