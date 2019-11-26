package hu.david.alairas.service;

import hu.david.alairas.entity.Alairas;
import hu.david.alairas.entity.Utonev;
import hu.david.alairas.repository.AlairasRepository;
import hu.david.alairas.repository.UtonevRepository;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  public Optional<Alairas> findOne(Integer id) {
    return alairasRepository.findById(id);
  }

  public List<Alairas> findAll() {
    return alairasRepository.findAll();
  }

  public Alairas addOne(String vezeteknev, Integer utonevId, Integer utonev_2Id, Boolean nemeNo,
      String megjegyzes) {
    Alairas alairas = new Alairas();
    alairas.setVezeteknev(vezeteknev);
    alairas.setUtonev(findUtonev(utonevId));
    if (!StringUtils.isEmpty(utonev_2Id)) {
      alairas.setUtonev_2(findUtonev(utonev_2Id));
    }
    alairas.setNemeNo(nemeNo != null && nemeNo);
    alairas.setMegjegyzes(megjegyzes);
    alairas.setLetrehozva(new Date());
    return alairasRepository.save(alairas);
  }

  public Alairas update(Alairas alairas, String vezeteknev, Integer utonevId, Integer utonev_2Id,
      Boolean nemeNo, String megjegyzes) {
    alairas.setVezeteknev(vezeteknev);
    alairas.setUtonev(findUtonev(utonevId));
    if (!StringUtils.isEmpty(utonev_2Id)) {
      alairas.setUtonev_2(findUtonev(utonev_2Id));
    } else {
      alairas.setUtonev_2(null);
    }
    alairas.setNemeNo(nemeNo != null && nemeNo);
    alairas.setMegjegyzes(megjegyzes);
    alairas.setModositva(new Date());
    return alairasRepository.save(alairas);
  }

  private Utonev findUtonev(Integer id) {
    return utonevRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Utónév azonosító nem található: " + id));
  }

  public List<Alairas> findSimilar(Alairas alairas) {
    List<Alairas> alairasList = alairasRepository
        .findByVezeteknevAndUtonevId(alairas.getVezeteknev(), alairas.getUtonev().getId());
    alairasList.remove(alairas);
    return alairasList;
  }

  public void deleteOne(Integer id) {
    Alairas alairas = findOne(id)
        .orElseThrow(() -> new ResourceNotFoundException("Aláírás azonosító nem található: " + id));
    if (alairas != null) {
      alairasRepository.delete(alairas);
    }
  }

  // PAGINATION
  public Page<Alairas> findPaginated(Pageable pageable) {
    List<Alairas> alairasok = findAll();

    int pageSize = pageable.getPageSize();
    int currentPage = pageable.getPageNumber();
    int startItem = currentPage * pageSize;
    List<Alairas> list;

    if (alairasok.size() < startItem) {
      list = Collections.emptyList();
    } else {
      int toIndex = Math.min(startItem + pageSize, alairasok.size());
      list = alairasok.subList(startItem, toIndex);
    }

    Page<Alairas> bookPage = new PageImpl<>(list, PageRequest.of(currentPage, pageSize),
        alairasok.size());

    return bookPage;
  }
}
