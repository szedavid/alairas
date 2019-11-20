package hu.david.alairas.service;

import hu.david.alairas.entity.Alairas;
import hu.david.alairas.repository.AlairasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AlairasService {

  private AlairasRepository alairasRepository;

  @Autowired
  public AlairasService(AlairasRepository alairasRepository) {
    this.alairasRepository = alairasRepository;
  }

  public Integer count() {
    return alairasRepository.findAll().size();
  }

  public List<Alairas> findAll(){
    return alairasRepository.findAll();
  }

  public Alairas addOne(String vezeteknev, String keresztnev, String keresztnev_2, Boolean nemeNo) {
    Alairas alairas = new Alairas();
    alairas.setVezeteknev(vezeteknev);
    alairas.setKeresztnev(keresztnev);
    if (!StringUtils.isEmpty(keresztnev_2)) {
      alairas.setKeresztnev_2(keresztnev_2);
    }
    alairas.setNemeNo(nemeNo != null && nemeNo);
    alairas.setLetrehozva(new Date());
    return alairasRepository.save(alairas);
  }

  public Alairas update(Alairas alairas, String vezeteknev, String keresztnev, String keresztnev_2, Boolean nemeNo) {
    alairas.setVezeteknev(vezeteknev);
    alairas.setKeresztnev(keresztnev);
    if (!StringUtils.isEmpty(keresztnev_2)) {
      alairas.setKeresztnev_2(keresztnev_2);
    } else {
      alairas.setKeresztnev_2(null);
    }
    alairas.setNemeNo(nemeNo != null && nemeNo);
    alairas.setModositva(new Date());
    return alairasRepository.save(alairas);
  }
}
