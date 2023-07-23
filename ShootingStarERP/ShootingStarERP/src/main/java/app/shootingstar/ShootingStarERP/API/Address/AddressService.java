package app.shootingstar.ShootingStarERP.API.Address;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class AddressService {

    @Autowired
    AddressRepository repo;

    public AddressService(AddressRepository repo){
        this.repo = repo;
    }

    public Address replaceAddress(Address address, int recordId){
        repo.inactive(recordId, new Date());
        return repo.save(address);
    }
}
