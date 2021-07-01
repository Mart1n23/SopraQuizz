import { Personne } from '../personne';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Validators, FormControl } from '@angular/forms';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  registerForm: FormGroup = new FormGroup({});
  loading = false;
  submitted = false;
  personne: Personne = new Personne();
  @Output('inscription')
  inscription: EventEmitter<Personne> = new EventEmitter<Personne>();
  constructor(private formBuilder: FormBuilder) {}

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
      ]),
      lastName: new FormControl('', [
        Validators.required,
        Validators.minLength(2),
      ]),
      email: new FormControl('', [Validators.required, Validators.email]),
      confirmPassword: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
      ]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
      ]),
    });
  }
  send() {
    console.log(this.registerForm);
    //this.inscription.emit(this.personne);
    this.personne = new Personne(...this.registerForm.value);
  }
}
