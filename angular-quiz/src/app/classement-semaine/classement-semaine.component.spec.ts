import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassementSemaineComponent } from './classement-semaine.component';

describe('ClassementSemaineComponent', () => {
  let component: ClassementSemaineComponent;
  let fixture: ComponentFixture<ClassementSemaineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClassementSemaineComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassementSemaineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
