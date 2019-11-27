package hu.david.alairas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
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

  @Override
  public String toString() {
    return nev;
  }
}
