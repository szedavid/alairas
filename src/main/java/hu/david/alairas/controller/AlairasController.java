package hu.david.alairas.controller;

import hu.david.alairas.entity.Alairas;
import hu.david.alairas.service.AlairasService;
import hu.david.alairas.service.UtonevService;
import org.springframework.beans.factory.annotation.Autowired;
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
  public AlairasController(AlairasService alairasService
      , UtonevService utonevService
  ) {
    this.alairasService = alairasService;
    this.utonevService = utonevService;
  }

  @GetMapping("/")
  public String getAlairasok(Model model) {
    model.addAttribute("alairasok", alairasService.findAll());
    return "alairasok"; // ez a html template jelenjen meg
  }

  @GetMapping("/{id}")
  public String getAlairas(@PathVariable Integer id, Model model) {
    Alairas alairas = alairasService.findOne(id)
        .orElseThrow(() -> new ResourceNotFoundException("Aláírás azonosító nem található: " + id));

    model.addAttribute("alairas", alairas);
    return "alairas"; // ez a html template jelenjen meg
  }

  @GetMapping("/hozzaadas")
  public String hozzaadas(Model model) {
    model.addAttribute("utonevek", utonevService.findAll());
    return "hozzaadas";
  }

  @PostMapping("/hozzaadas")
  public String hozzaadas(@RequestParam String vezeteknev, @RequestParam Integer utonevId,
      @RequestParam(required = false) Integer utonev_2Id,
      @RequestParam(required = false) Boolean nemeNo, Model model) {
    Alairas alairas = alairasService.addOne(vezeteknev, utonevId, utonev_2Id, nemeNo);
    return getAlairas(alairas.getId(), model);
  }

  @GetMapping("/szerkesztes/{id}")
  public String szerkesztes(@PathVariable Integer id, Model model) {
    Alairas alairas = alairasService.findOne(id)
        .orElseThrow(() -> new ResourceNotFoundException("Aláírás azonosító nem található: " + id));

    model.addAttribute("alairas", alairas);
    model.addAttribute("utonevek", utonevService.findAll());
    return "szerkesztes";
  }

  @PostMapping("/szerkesztes/{id}")
  public String szerkesztes(@PathVariable Integer id, @RequestParam String vezeteknev, @RequestParam Integer utonevId,
      @RequestParam(required = false) Integer utonev_2Id,
      @RequestParam(required = false) Boolean nemeNo, Model model) {
    Alairas alairas = alairasService.findOne(id)
        .orElseThrow(() -> new ResourceNotFoundException("Aláírás azonosító nem található: " + id));

    alairasService.update(alairas, vezeteknev, utonevId, utonev_2Id, nemeNo);
    return getAlairas(alairas.getId(), model);
  }
}
