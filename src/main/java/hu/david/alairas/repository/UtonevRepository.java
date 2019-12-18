package hu.david.alairas.repository;

import hu.david.alairas.entity.Utonev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "utonevek", path = "utonevek")
public interface UtonevRepository extends JpaRepository<Utonev, Integer> {

}
