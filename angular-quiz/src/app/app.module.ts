import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TableauPrincipalComponent } from './tableau-principal/tableau-principal.component';
import { ClassementSemaineComponent } from './classement-semaine/classement-semaine.component';

@NgModule({
  declarations: [
    AppComponent,
    TableauPrincipalComponent,
    ClassementSemaineComponent,
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
