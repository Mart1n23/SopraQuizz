import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'angular-quiz';

  constructor(private router: Router) {}

  estConnecte(): boolean {
    return localStorage.getItem('login') ? true : false;
  }
}
