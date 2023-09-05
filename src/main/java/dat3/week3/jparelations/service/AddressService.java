package dat3.week3.jparelations.service;

import dat3.week3.jparelations.entity.Address;
import dat3.week3.jparelations.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public void printFullAddressInfo(int id, boolean includeCitizens){
        Address address = addressRepository.findById(id).get();
        System.out.println(address.getStreet());
        if (includeCitizens){
            System.out.println("Citizens: "+address.getCitizens().size());
        }
    }
}
