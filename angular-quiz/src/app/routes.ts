import { ErreurComponent } from './erreur/erreur.component';
import { QuizsComponent } from './quizs/quizs.component';
import { CompteComponent } from './compte/compte.component';
import { ResauxComponent } from './resaux/resaux.component';
import { ClassementComponent } from './classement/classement.component';
import { HomeComponent } from './home/home.component';
import { RouterModule, Routes } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { AdminComponent } from './admin/admin.component';
import { NgModule } from '@angular/core';
import { InscriptionComponent } from './inscription/inscription.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'classement', component: ClassementComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'quiz', component: QuizsComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'compte', component: CompteComponent },
  { path: 'resaux', component: ResauxComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
