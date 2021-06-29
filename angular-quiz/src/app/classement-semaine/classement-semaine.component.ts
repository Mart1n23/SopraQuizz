import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-classement-semaine',
  templateUrl: './classement-semaine.component.html',
  styleUrls: ['./classement-semaine.component.css'],
})
export class ClassementSemaineComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}
}
