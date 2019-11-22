package hu.david.alairas.service;

import hu.david.alairas.entity.Alairas;
import hu.david.alairas.repository.AlairasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AlairasService {

  private AlairasRepository alairasRepository;
  private UtonevRepository utonevRepository;

  @Autowired
  public AlairasService(AlairasRepository alairasRepository, UtonevRepository utonevRepository) {
    this.alairasRepository = alairasRepository;
    this.utonevRepository = utonevRepository;
  }

  public Integer count() {
    return alairasRepository.findAll().size();
  }

  public List<Alairas> findAll(){
    return alairasRepository.findAll();
  }

  public Alairas addOne(String vezeteknev, Integer utonevId, Integer utonev_2Id, Boolean nemeNo) {
    Alairas alairas = new Alairas();
    alairas.setVezeteknev(vezeteknev);
    alairas.setUtonev(findUtonev(utonevId));
    if (!StringUtils.isEmpty(utonev_2Id)) {
      alairas.setUtonev_2(findUtonev(utonev_2Id));
    }
    alairas.setNemeNo(nemeNo != null && nemeNo);
    alairas.setLetrehozva(new Date());
    return alairasRepository.save(alairas);
  }

  public Alairas update(Alairas alairas, String vezeteknev, Integer utonevId, Integer utonev_2Id, Boolean nemeNo) {
    alairas.setVezeteknev(vezeteknev);
    alairas.setUtonev(findUtonev(utonevId));
    if (!StringUtils.isEmpty(utonev_2Id)) {
      alairas.setUtonev_2(findUtonev(utonev_2Id));
    } else {
      alairas.setUtonev_2(null);
    }
    alairas.setNemeNo(nemeNo != null && nemeNo);
    alairas.setModositva(new Date());
    return alairasRepository.save(alairas);
  }

  private Utonev findUtonev(Integer id){
    return utonevRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Utónév azonosító nem található: " + id)
    );
  }
}
