package dat3.week3.jparelations.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String zip;
    private String city;

    @OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Citizen> citizens = new ArrayList<>();

    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public void addCitizen(Citizen citizen){
        citizens.add(citizen);
        citizen.setAddress(this);
    }
}
