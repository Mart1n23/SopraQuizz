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
import { CompteComponent } from './compte/compte.component';
import { QuizsComponent } from './quizs/quizs.component';
import { FormsModule } from '@angular/forms';
import { routes } from './routes';
import { ClassementComponent } from './classement/classement.component';

@NgModule({
  declarations: [
    AppComponent,
    TableauPrincipalComponent,
    ClassementSemaineComponent,
    InscriptionComponent,
    ConnexionComponent,
    HomeComponent,
    ResauxComponent,
    CompteComponent,
    QuizsComponent,
    ClassementComponent,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
