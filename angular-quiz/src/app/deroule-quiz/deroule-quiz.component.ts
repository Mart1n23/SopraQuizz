import { ScoreKey } from './../model/score-key';
import { Score } from './../model/score';
import { ScoreService } from './../services/score.service';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { Question } from './../model/question';
import { QuizService } from './../services/quiz.service';
import { Observable } from 'rxjs';
import { Quiz } from './../model/quiz';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-deroule-quiz',
  templateUrl: './deroule-quiz.component.html',
  styleUrls: ['./deroule-quiz.component.css'],
})
export class DerouleQuizComponent implements OnInit {
  quiz: Quiz | any = null;
  reponseCtrl: FormControl;
  compteur: number = 0;
  displayQuestion: number = 0;
  score: Score = new Score();
  scorekey: ScoreKey = new ScoreKey();
  //form: FormGroup;
  //questions : Observable<Question[]> | any = null;

  afficherQuestion(score: number) {
    this.displayQuestion++;
    this.compteur += score;
    if (this.displayQuestion == this.quiz.questions.length) {
      this.score = new Score(this.compteur);
      this.scoreService.create(this.score, this.quiz.id).subscribe();
    }
  }
  constructor(
    private quizService: QuizService,
    private scoreService: ScoreService,
    private fb: FormBuilder
  ) {
    this.reponseCtrl = fb.control('');
  }

  ngOnInit(): void {
    this.quizService.getWithQuestions(103).subscribe((result) => {
      this.quiz = result;
    });
    //console.log(this.quiz.nom);
    //this.questions = this.quiz.questions;
    //console.log(this.questions);
  }

  save() {
    console.log(this.compteur);
    /*if (this.reponseCtrl.value == this.quiz.questions.verif) {
      this.compteur++;
    }
    console.log(this.compteur);*/
  }
}
