import { Utonev } from './utonev.model';

export class Alairas {
  id: number;

  // @NotBlank
  // @Size(max = 32)
  // @Column(nullable = false)
  vezeteknev: string;

  // @ManyToOne
  // @JoinColumn(name="UTONEV_ID", nullable = false)
  // @RestResource(exported = false)
  utonev: Utonev;

  // @ManyToOne
  // @JoinColumn(name="UTONEV_2_ID")
  // @RestResource(exported = false)
  utonev_2: Utonev;

  // @Column(nullable = false)
  nemeNo: boolean;

  // @Size(max = 256)
  infoLink: string;

  // @Size(max = 500)
  megjegyzes: string;

  // @Temporal(TemporalType.DATE)
  // @Column(nullable = false)
  letrehozva;

  // @Temporal(TemporalType.DATE)
  modositva;
}
