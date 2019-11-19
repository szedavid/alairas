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
  public AlairasController(AlairasService alairasService){
    this.alairasService = alairasService;
  }

  @GetMapping("/alairas")
  @ResponseBody
  public String getHelloWorld() {
    List<Alairas> list = alairasService.findAll();

    StringBuilder sb = new StringBuilder("<p>Felhasználók:</p>");
    for (Alairas alairas : list) {
      sb.append("<br>");
      sb.append(alairas.getVezeteknev()).append(" ").append(alairas.getKeresztnev_1());
      if(!StringUtils.isEmpty(alairas.getKeresztnev_2())){
        sb.append(" ").append(alairas.getKeresztnev_2());
      }
      sb.append("\n");
    }

    return sb.toString();
  }
}
