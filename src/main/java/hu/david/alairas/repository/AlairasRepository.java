package hu.david.alairas.repository;

import hu.david.alairas.entity.Alairas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlairasRepository extends JpaRepository<Alairas, Integer> {
  List<Alairas> findByVezeteknevAndUtonevId(String vezeteknev, Integer utonevId);
}
