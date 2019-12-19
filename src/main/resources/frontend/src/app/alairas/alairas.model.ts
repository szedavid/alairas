import { Utonev } from './utonev.model';

export class Alairas {
  private id: number;

  // @NotBlank
  // @Size(max = 32)
  // @Column(nullable = false)
  private vezeteknev: string;

  // @ManyToOne
  // @JoinColumn(name="UTONEV_ID", nullable = false)
  // @RestResource(exported = false)
  private utonev: Utonev;

  // @ManyToOne
  // @JoinColumn(name="UTONEV_2_ID")
  // @RestResource(exported = false)
  private utonev_2: Utonev;

  // @Column(nullable = false)
  private nemeNo: boolean;

  // @Size(max = 256)
  private infoLink: string;

  // @Size(max = 500)
  private megjegyzes: string;

  // @Temporal(TemporalType.DATE)
  // @Column(nullable = false)
  private letrehozva;

  // @Temporal(TemporalType.DATE)
  private modositva;
}
