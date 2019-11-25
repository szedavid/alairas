package hu.david.alairas.service;

import hu.david.alairas.entity.Utonev;
import hu.david.alairas.repository.UtonevRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtonevService {

  private UtonevRepository utonevRepository;

  @Autowired
  public UtonevService(UtonevRepository utonevRepository) {
    this.utonevRepository = utonevRepository;
  }

  public List<Utonev> findAll() {
    return utonevRepository.findAll();
  }
}
