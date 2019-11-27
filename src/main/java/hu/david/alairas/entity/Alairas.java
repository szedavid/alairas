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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "ALAIRAS")
public class Alairas {

  @Id
  @GeneratedValue
  private Integer id;

  @NotBlank
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

  @Size(max = 256)
  private String infoLink;

  @Size(max = 500)
  private String megjegyzes;

  @Temporal(TemporalType.DATE)
  @Column(nullable = false)
  private Date letrehozva;

  @Temporal(TemporalType.DATE)
  @Column
  private Date modositva;

  @Override
  public String toString() {
    return vezeteknev + " " + utonev + (utonev_2 != null ? (" " + utonev_2) : "");
  }
}
