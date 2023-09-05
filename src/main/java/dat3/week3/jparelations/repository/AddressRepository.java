package dat3.week3.jparelations.repository;

import dat3.week3.jparelations.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
