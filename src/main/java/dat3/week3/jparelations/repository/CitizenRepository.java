package dat3.week3.jparelations.repository;

import dat3.week3.jparelations.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
}
