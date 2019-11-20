package hu.david.alairas.repository;

import hu.david.alairas.entity.Alairas;
import hu.david.alairas.entity.Utonev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtonevRepository extends JpaRepository<Utonev, Integer> {

}
