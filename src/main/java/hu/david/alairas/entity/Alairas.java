package hu.david.alairas.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="UTONEV_ID", nullable = false)
  private Utonev utonev;

  @ManyToOne(fetch= FetchType.LAZY)
  @JoinColumn(name="UTONEV_2_ID")
  private Utonev utonev_2;

  @Column(nullable = false)
  private Boolean nemeNo;

  @Size(max = 500)
  private String megjegyzes;

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

  public Utonev getUtonev() {
    return utonev;
  }

  public void setUtonev(Utonev utonev) {
    this.utonev = utonev;
  }

  public Utonev getUtonev_2() {
    return utonev_2;
  }

  public void setUtonev_2(Utonev utonev_2) {
    this.utonev_2 = utonev_2;
  }

  public Boolean getNemeNo() {
    return nemeNo;
  }

  public void setNemeNo(Boolean nemeNo) {
    this.nemeNo = nemeNo;
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

  public String getMegjegyzes() {
    return megjegyzes;
  }

  public void setMegjegyzes(String megjegyzes) {
    this.megjegyzes = megjegyzes;
  }

  @Override
  public String toString() {
    return vezeteknev + " " + utonev + (utonev_2 != null ? (" " + utonev_2) : "");
  }
}
