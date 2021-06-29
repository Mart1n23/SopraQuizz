import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableauPrincipalComponent } from './tableau-principal.component';

describe('TableauPrincipalComponent', () => {
  let component: TableauPrincipalComponent;
  let fixture: ComponentFixture<TableauPrincipalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableauPrincipalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TableauPrincipalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
