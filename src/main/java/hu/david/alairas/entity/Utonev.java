package hu.david.alairas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UTONEV",
    indexes = {
        @Index(columnList = "id", name = "id_idx")
    }
)
public class Utonev {

  @Id
  @GeneratedValue
  private Integer id;

  @Size(max = 16)
  @Column(nullable = false)
  private String nev;

  @Column(nullable = false)
  private Boolean nemeNo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNev() {
    return nev;
  }

  public void setNev(String nev) {
    this.nev = nev;
  }

  public Boolean getNemeNo() {
    return nemeNo;
  }

  public void setNemeNo(Boolean nemeNo) {
    this.nemeNo = nemeNo;
  }

  @Override
  public String toString() {
    return nev;
  }
}
