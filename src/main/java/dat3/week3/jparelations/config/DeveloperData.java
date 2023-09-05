package dat3.week3.jparelations.config;

import dat3.week3.jparelations.entity.Address;
import dat3.week3.jparelations.entity.Citizen;
import dat3.week3.jparelations.entity.Town;
import dat3.week3.jparelations.repository.AddressRepository;
import dat3.week3.jparelations.repository.CitizenRepository;
import dat3.week3.jparelations.repository.TownRepository;
import dat3.week3.jparelations.service.AddressService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class DeveloperData implements ApplicationRunner {
    private final TownRepository townRepository;
    private final CitizenRepository citizenRepository;
    private final AddressRepository addressRepository;
    private final AddressService addressService;

    public DeveloperData(TownRepository townRepository, CitizenRepository citizenRepository, AddressRepository addressRepository, AddressService addressService) {
        this.townRepository = townRepository;
        this.citizenRepository = citizenRepository;
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Town town1 = new Town("Copenhagen", "2300", "Anders", 12);
        townRepository.save(town1);

        Address a1 = new Address("Lyngbyvej 1", "Lyngby", "2800");
        Citizen citizen1 = new Citizen("Kurt", "Wonnegut", "a@b.dk", "123");
        Citizen citizen2 = new Citizen("Hanne", "Wonnegut", "h@b.dk", "234");
        citizen1.setTown(town1);
        citizen2.setTown(town1);
        a1.addCitizen(citizen1);
        a1.addCitizen(citizen2);
        addressRepository.save(a1); // Save the address

        /*System.out.println("------- Select statements starts here ------------");
        Address address_1 = addressRepository.findById(a1.getId()).get();
        System.out.println(address_1.getStreet());
        System.out.println("Press Enter to continue");
        System.in.read();  //This will block so you have time to read the DEBUG statements
        System.out.println("Citizens: "+address_1.getCitizens().size());*/


        addressService.printFullAddressInfo(a1.getId(), true);
        addressService.printFullAddressInfo(a1.getId(), false);
    }
}
