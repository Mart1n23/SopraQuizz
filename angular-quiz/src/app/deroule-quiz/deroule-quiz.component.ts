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
  quiz: Observable<Quiz> | any = null;
  questions: Observable<Question[]> | any = null;

  constructor(private quizService: QuizService) {}

  ngOnInit(): void {
    this.quiz = this.quizService.getWithQuestions(103);
    console.log(this.quiz.nom);
    this.questions = this.quiz.questions;
    console.log(this.questions);
  }
}
