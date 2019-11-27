package hu.david.alairas.controller;

import hu.david.alairas.entity.Alairas;
import hu.david.alairas.service.AlairasService;
import hu.david.alairas.service.UtonevService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlairasController {
  private AlairasService alairasService;
  private UtonevService utonevService;

  @Autowired
  public AlairasController(AlairasService alairasService, UtonevService utonevService) {
    this.alairasService = alairasService;
    this.utonevService = utonevService;
  }

  @GetMapping("/")
  public String getAlairasok(
      @RequestParam("page") Optional<Integer> page,
      @RequestParam("size") Optional<Integer> size,
      Model model) {
    int currentPage = page.orElse(1);
    int pageSize = size.orElse(25);

    Page<Alairas> alairasPage = alairasService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
    model.addAttribute("alairasPage", alairasPage);

    int totalPages = alairasPage.getTotalPages();
    if (totalPages > 0) {
      List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
          .boxed()
          .collect(Collectors.toList());
      model.addAttribute("pageNumbers", pageNumbers);
    }

    return "alairasok"; // ez a html template jelenjen meg
  }

  @GetMapping("/{id}")
  public String getAlairas(@PathVariable Integer id, Model model) {
    Alairas alairas = alairasService.findOne(id)
        .orElseThrow(() -> new ResourceNotFoundException("Aláírás azonosító nem található: " + id));

    model.addAttribute("alairas", alairas);
    List<Alairas> hasonloNevek = alairasService.findSimilar(alairas);
    if (hasonloNevek.size() > 0) {
      model.addAttribute("hasonloNevek", hasonloNevek);
    }
    return "alairas"; // ez a html template jelenjen meg
  }

  // todo DeleteMapping-al
  @GetMapping("/torles/{id}")
  public String deleteAlairas(@PathVariable Integer id, Model model) {
    alairasService.deleteOne(id);
    model.addAttribute("alairasok", alairasService.findAllOrderByVezeteknev());
    return "alairasok"; // ez a html template jelenjen meg
  }

  @GetMapping("/hozzaadas")
  public String hozzaadas(Model model) {
    model.addAttribute("utonevek", utonevService.findAll());
    return "hozzaadas";
  }

  @PostMapping("/hozzaadas")
  public String hozzaadas(
      @RequestParam String vezeteknev,
      @RequestParam Integer utonevId,
      @RequestParam(required = false) Integer utonev2Id,
      @RequestParam(required = false) Boolean nemeNo,
      @RequestParam(required = false) String infoLink,
      @RequestParam(required = false) String megjegyzes,
      Model model) {
    Alairas alairas = alairasService.addOne(vezeteknev, utonevId, utonev2Id, nemeNo, infoLink, megjegyzes);
    return getAlairas(alairas.getId(), model);
  }

  @GetMapping("/szerkesztes/{id}")
  public String szerkesztes(@PathVariable Integer id, Model model) {
    Alairas alairas = alairasService.findOne(id)
        .orElseThrow(() -> new ResourceNotFoundException("Aláírás azonosító nem található: " + id));

    model.addAttribute("alairas", alairas);
    model.addAttribute("utonevek", utonevService.findAll());

    List<Alairas> hasonloNevek = alairasService.findSimilar(alairas);
    if (hasonloNevek.size() > 0) {
      model.addAttribute("hasonloNevek", hasonloNevek);
    }

    return "szerkesztes";
  }

  @PostMapping("/szerkesztes/{id}")
  public String szerkesztes(
      @PathVariable Integer id,
      @RequestParam String vezeteknev,
      @RequestParam Integer utonevId,
      @RequestParam(required = false) Integer utonev_2Id,
      @RequestParam(required = false) Boolean nemeNo,
      @RequestParam(required = false) String infoLink,
      @RequestParam(required = false) String megjegyzes,
      Model model) {
    Alairas alairas = alairasService.findOne(id)
        .orElseThrow(() -> new ResourceNotFoundException("Aláírás azonosító nem található: " + id));

    alairasService.update(alairas, vezeteknev, utonevId, utonev_2Id, nemeNo, infoLink, megjegyzes);
    return getAlairas(alairas.getId(), model);
  }
}
