import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { TableauPrincipalComponent } from './tableau-principal/tableau-principal.component';
import { ClassementSemaineComponent } from './classement-semaine/classement-semaine.component';
import { HomeComponent } from './home/home.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { ResauxComponent } from './resaux/resaux.component';
import { QuizsComponent } from './quizs/quizs.component';
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

@NgModule({
  declarations: [
    AppComponent,
    TableauPrincipalComponent,
    ClassementSemaineComponent,
    InscriptionComponent,
    ConnexionComponent,
    HomeComponent,
    ResauxComponent,
    QuizsComponent,
    ClassementComponent,
    UtilisateurComponent,
    ErreurComponent,
    PersonneComponent,
    LogedComponent,
    NotlogedComponent,
    CompteComponent,
    AdminComponent,
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
