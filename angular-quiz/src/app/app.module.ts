import { DerouleQuizComponent } from './deroule-quiz/deroule-quiz.component';
import { IntroQuizzComponent } from './intro-quizz/intro-quizz.component';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';

import { HomeComponent } from './home/home.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { ResauxComponent } from './resaux/resaux.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule, routes } from './routes';
import { ClassementComponent } from './classement/classement.component';
import { HttpClientModule } from '@angular/common/http';
import { UtilisateurComponent } from './utilisateur/utilisateur.component';
import { ErreurComponent } from './erreur/erreur.component';
import { PersonneComponent } from './personne/personne.component';
import { LogedComponent } from './loged/loged.component';
import { NotlogedComponent } from './notloged/notloged.component';
import { CompteComponent } from './compte/compte.component';
import { AdminComponent } from './admin/admin.component';
import { FinalQuizComponent } from './final-quiz/final-quiz.component';

@NgModule({
  declarations: [
    AppComponent,
    InscriptionComponent,
    ConnexionComponent,
    HomeComponent,
    ResauxComponent,
    ClassementComponent,
    UtilisateurComponent,
    ErreurComponent,
    PersonneComponent,
    LogedComponent,
    NotlogedComponent,
    CompteComponent,
    AdminComponent,
    IntroQuizzComponent,
    FinalQuizComponent,
    DerouleQuizComponent,
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
