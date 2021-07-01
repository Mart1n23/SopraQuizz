import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-intro-quizz',
  templateUrl: './intro-quizz.component.html',
  styleUrls: ['./intro-quizz.component.css']
})
export class IntroQuizzComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  quiz1() {
    this.router.navigate(['/deroule-quiz'])
  }
}
