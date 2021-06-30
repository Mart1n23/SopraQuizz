import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotlogedComponent } from './notloged.component';

describe('NotlogedComponent', () => {
  let component: NotlogedComponent;
  let fixture: ComponentFixture<NotlogedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotlogedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NotlogedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
