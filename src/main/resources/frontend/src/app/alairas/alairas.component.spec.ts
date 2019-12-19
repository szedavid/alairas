import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlairasComponent } from './alairas.component';

describe('AlairasComponent', () => {
  let component: AlairasComponent;
  let fixture: ComponentFixture<AlairasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlairasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlairasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
