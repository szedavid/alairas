package hu.david.alairas.controller;

import hu.david.alairas.entity.Alairas;
import hu.david.alairas.service.AlairasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlairasController {

  private AlairasService alairasService;

  @Autowired
  public AlairasController(AlairasService alairasService) {
    this.alairasService = alairasService;
  }

  @GetMapping("/")
  public String getAlairasok(Model model) {
    model.addAttribute("alairasok", alairasService.findAll());
    return "alairasok"; // ez a html template jelenjen meg
  }
}
