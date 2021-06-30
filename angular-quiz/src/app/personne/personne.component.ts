import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.css'],
})
export class PersonneComponent implements OnInit {
  email: string = '';
  password: string = '';
  first_name: string = '';
  last_name: string = '';
  constructor() {}

  ngOnInit(): void {}
}
