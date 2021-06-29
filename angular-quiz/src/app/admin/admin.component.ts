import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConnexionService } from '../connexion.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
})
export class AdminComponent implements OnInit {
  constructor(
    private connexionService: ConnexionService,
    private router: Router
  ) {}

  ngOnInit() {}

  seDeconnecter() {
    this.connexionService.seDeconnecter();
    this.router.navigateByUrl('/connexion');
  }
}
