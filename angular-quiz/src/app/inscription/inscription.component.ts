import { Personne } from '../personne';
import { PersonneComponent } from './../personne/personne.component';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  registerForm!: FormGroup;
  loading = false;
  submitted = false;
  personne: Personne = new Personne();
  @Output('inscription')
  inscription: EventEmitter<Personne> = new EventEmitter<Personne>();
  formBuilder: any;
  constructor() {}

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(6)]],
    });
  }
  send() {
    this.inscription.emit(this.personne);
    this.personne = new Personne();
  }
}
