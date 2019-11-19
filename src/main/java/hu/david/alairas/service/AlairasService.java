package hu.david.alairas.service;

import hu.david.alairas.entity.Alairas;
import hu.david.alairas.repository.AlairasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlairasService {

  private AlairasRepository alairasRepository;

  @Autowired
  public AlairasService(AlairasRepository alairasRepository){
    this.alairasRepository = alairasRepository;
  }

  public Integer count(){
    return alairasRepository.findAll().size();
  }

  public List<Alairas> findAll(){
    return alairasRepository.findAll();
  }
}
