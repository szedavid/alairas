package hu.david.alairas.repository;

import hu.david.alairas.entity.Alairas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "alairasok", path = "alairasok")
public interface AlairasRepository extends JpaRepository<Alairas, Integer> {
  List<Alairas> findByVezeteknevAndUtonevIdOrderByVezeteknev(String vezeteknev, Integer utonevId);
}
