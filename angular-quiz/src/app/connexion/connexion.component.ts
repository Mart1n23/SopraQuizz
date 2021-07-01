import { LoginService } from './../services/login.service';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css'],
})
export class ConnexionComponent implements OnInit {
  loginForm!: FormGroup;
  isSubmitted = false;
  message:string ='';

  constructor(
    private loginService: LoginService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [
        Validators.required,
        //Validators.minLength(6),
      ]),
    });
  }
  get formControls() {
    return this.loginForm.controls;
  }
  seConnecter() {
    //console.log(this.loginForm.value.email);
    this.isSubmitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    //this.ConnexionService.seConnecter(this.loginForm.value);
    this.loginService.login(this.loginForm.value.email, this.loginForm.value.password).subscribe(
      (result) => {
        localStorage.setItem('login', this.loginForm.value.email);
        localStorage.setItem(
          'auth',
          'Basic ' + btoa(this.loginForm.value.email + ':' + this.loginForm.value.password)
        );
        this.router.navigate(['/home']);
      },
      (error) => {
        this.message = 'Informations de connexion incorrectes';
      }
    );
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
