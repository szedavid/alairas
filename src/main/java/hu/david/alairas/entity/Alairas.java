package hu.david.alairas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ALAIRAS")
public class Alairas {

  @Id
  @GeneratedValue
  private Integer id;

  @Size(max = 32)
  @Column(nullable = false)
  private String vezeteknev;

  @Size(max = 16)
  @Column(nullable = false)
  private String keresztnev_1;

  @Size(max = 16)
  private String keresztnev_2;

  @Column(nullable = false)
  private Boolean nem;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getVezeteknev() {
    return vezeteknev;
  }

  public void setVezeteknev(String vezeteknev) {
    this.vezeteknev = vezeteknev;
  }

  public String getKeresztnev_1() {
    return keresztnev_1;
  }

  public void setKeresztnev_1(String keresztnev_1) {
    this.keresztnev_1 = keresztnev_1;
  }

  public String getKeresztnev_2() {
    return keresztnev_2;
  }

  public void setKeresztnev_2(String keresztnev_2) {
    this.keresztnev_2 = keresztnev_2;
  }

  public Boolean getNem() {
    return nem;
  }

  public void setNem(Boolean nem) {
    this.nem = nem;
  }
}
