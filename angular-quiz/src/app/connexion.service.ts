import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ConnexionService {
  seDeconnecter() {
    throw new Error('Method not implemented.');
  }
  seConnecter(value: any) {
    throw new Error('Method not implemented.');
  }
  constructor() {
    localStorage.setItem('ACCESS_TOKEN', 'access_token');
  }
  public estConnecte() {
    return localStorage.getItem('ACCESS_TOKEN') !== null;
  }
  public deconnecter() {
    localStorage.removeItem('ACCESS_TOKEN');
  }
}
