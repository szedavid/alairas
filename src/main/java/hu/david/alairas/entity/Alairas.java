package hu.david.alairas.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
  private String keresztnev;

  @Size(max = 16)
  private String keresztnev_2;

  @Column(nullable = false)
  private Boolean nemeNo;

  @Temporal(TemporalType.DATE)
  @Column(nullable = false)
  private Date letrehozva;

  @Temporal(TemporalType.DATE)
  @Column
  private Date modositva;

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

  public String getKeresztnev() {
    return keresztnev;
  }

  public void setKeresztnev(String keresztnev) {
    this.keresztnev = keresztnev;
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

  public Date getLetrehozva() {
    return letrehozva;
  }

  public void setLetrehozva(Date letrehozva) {
    this.letrehozva = letrehozva;
  }

  public Date getModositva() {
    return modositva;
  }

  public void setModositva(Date modositva) {
    this.modositva = modositva;
  }

  @Override
  public String toString() {
    return vezeteknev + " " + keresztnev + (keresztnev_2 != null ? (" " + keresztnev_2) : "");
  }
}
