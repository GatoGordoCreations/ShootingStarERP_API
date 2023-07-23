package app.shootingstar.ShootingStarERP.API.Phone;


import lombok.NoArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PhoneService {

    @Autowired
    private PhoneRepository repo;

    @Autowired
    private PhoneTypeRepository typeRepo;


    public PhoneService(PhoneRepository repo, PhoneTypeRepository typeRepo){
        this.repo = repo;
        this.typeRepo = typeRepo; }

    List<PhoneType> phoneTypes;
    public List<PhoneJoin> getPhoneAndTypes(int id){
        List<Phone> phoneList = this.repo.getAllByEntity_ID(id);

        List<PhoneJoin> phoneJoin = new ArrayList();

        phoneTypes = this.typeRepo.findAll();

        for(Phone item: phoneList){
            PhoneJoin newObj = new PhoneJoin();

            newObj.setId(item.getId());
            newObj.setPhone_type(item.getPhone_type());
            newObj.setEntity_id(item.getEntity_id());
            newObj.setPhone_num1(item.getPhone_num1());
            newObj.setPhone_num2(item.getPhone_num2());
            newObj.setPhone_num3(item.getPhone_num3());
            newObj.setPhone_ext(item.getPhone_ext());
            newObj.setOut_of_service(item.isOut_of_service());

            newObj.setShort_desc(findTypeDesc(item.getPhone_type()));

            phoneJoin.add(newObj);
        }

        return phoneJoin;
    }

    private String findTypeDesc(String val){
        for(PhoneType type: this.phoneTypes){
            if(type.getPhone_type().equals(val)) {
                return type.getShort_desc();
            }
        }
        return "err";
    }

    public Phone replacePhone(Phone phone, int recordId){
        Date date = new Date();
        repo.inactive(recordId, date);
        return repo.save(phone);

    }

}
