package dat3.week3.jparelations.repository;

import dat3.week3.jparelations.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TownRepository extends JpaRepository<Town, Integer> {
}
