import { Personne } from '../personne';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Validators, FormControl, AsyncValidatorFn } from '@angular/forms';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  registerForm!: FormGroup;
  loading = false;
  isSubmitted = false;
  personne: Personne = new Personne();
  @Output('inscription')
  inscription: EventEmitter<Personne> = new EventEmitter<Personne>();
  constructor(private formBuilder: FormBuilder, private router: Router) {}

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(6),
      ]),
    });
  }
  send() {
    console.log(this.registerForm);
    this.personne = new Personne(this.registerForm.value);
  }
  get formControls() {
    return this.registerForm.controls;
  }
  /*
  checkMail(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.utilisateurService.checkMail(control.value).pipe(
        debounceTime(500),
        map((fournisseur: Fournisseur) => {
          if (this.fournisseur.contact != fournisseur.contact) {
            return fournisseur.id ? { mailExist: true } : null;
          } else {
            return null;
          }
        })
      );
    };
  }*/
}
