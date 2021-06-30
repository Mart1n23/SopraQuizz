import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IntroQuizzComponent } from './intro-quizz.component';

describe('IntroQuizzComponent', () => {
  let component: IntroQuizzComponent;
  let fixture: ComponentFixture<IntroQuizzComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IntroQuizzComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IntroQuizzComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
