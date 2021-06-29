import { QuizsComponent } from './quizs/quizs.component';
import { CompteComponent } from './compte/compte.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ResauxComponent } from './resaux/resaux.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'quizs', component: QuizsComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'compte', component: CompteComponent },
  { path: 'resaux', component: ResauxComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
