import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResauxComponent } from './resaux.component';

describe('ResauxComponent', () => {
  let component: ResauxComponent;
  let fixture: ComponentFixture<ResauxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResauxComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ResauxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
