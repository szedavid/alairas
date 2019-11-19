package hu.david.alairas.repository;

import hu.david.alairas.entity.Alairas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlairasRepository extends JpaRepository<Alairas, Integer> {

}
