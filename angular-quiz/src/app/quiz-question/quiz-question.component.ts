import { FormControl, FormBuilder } from '@angular/forms';
import { Question } from './../model/question';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-quiz-question',
  templateUrl: './quiz-question.component.html',
  styleUrls: ['./quiz-question.component.css'],
})
export class QuizQuestionComponent implements OnInit {
  reponseCtrl: FormControl;
  compteur: number = 0;
  @Input()
  numeroQuestion: number = 0;
  @Input()
  question: Question | any = null;
  @Output()
  choix: EventEmitter<number> = new EventEmitter();

  constructor(private fb: FormBuilder) {
    this.reponseCtrl = fb.control('');
  }

  ngOnInit(): void {}

  save() {
    if (this.reponseCtrl.value == this.question.verif) {
      this.choix.emit(1);
    } else {
      this.choix.emit(0);
    }
  }
}
