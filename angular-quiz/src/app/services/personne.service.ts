import { Personne } from './../model/personne';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonneService {
  private static URL = 'http://localhost:8081/boot/api/personne';
  private httpHeader: HttpHeaders = new HttpHeaders();

  constructor(private http: HttpClient) { }

  private initHeader() {
    const auth = localStorage.getItem('auth');
    this.httpHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: auth ? auth : '',
    });
  }

  public getAll(): Observable<Object[]> {
    this.initHeader();
    return this.http.get<Object[]>(PersonneService.URL, {
      headers: this.httpHeader,
    });
  }

  public get(id: number): Observable<Personne> {
    this.initHeader();
    return this.http.get<Personne>(PersonneService.URL+ '/' + id, {
      headers: this.httpHeader,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(PersonneService.URL+ '/' + id, {
      headers: this.httpHeader,
    });
  }

  public create(personne: Personne): Observable<Personne> {
    this.initHeader();
    const personneFormate = {
      nom: personne.nom,
      prenom: personne.prenom,
      mail: personne.mail,
      password: personne.password,
      role: personne.role,
    }
    return this.http.post<Personne>(PersonneService.URL, personneFormate, {
      headers: this.httpHeader,
    });
  }

  public update(personne: Personne): Observable<Personne> {
    this.initHeader();
    return this.http.put<Personne>(PersonneService.URL+ '/' + personne.id, personne, {
      headers: this.httpHeader,
    });
  }
}
