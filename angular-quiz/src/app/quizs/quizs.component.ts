import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-quizs',
  templateUrl: './quizs.component.html',
  styleUrls: ['./quizs.component.css'],
})
export class QuizsComponent implements OnInit {

  constructor(
    private router: Router,
    ) {}

  ngOnInit(): void {}

  debutQuiz() {
    this.router.navigate(['/intro-quizz']);
  }
}
