import { Question } from './../model/question';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  private static URL = 'http://localhost:8081/boot/api/question';
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
    return this.http.get<Object[]>(QuestionService.URL, {
      headers: this.httpHeader,
    });
  }

  public get(id: number): Observable<Question> {
    this.initHeader();
    return this.http.get<Question>(QuestionService.URL+ '/' + id, {
      headers: this.httpHeader,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(QuestionService.URL+ '/' + id, {
      headers: this.httpHeader,
    });
  }

  public create(question: Question): Observable<Question> {
    this.initHeader();
    const questionFormate = {
      intitule: question.intitule,
      reponse1: question.reponse1,
      reponse2: question.reponse2,
      reponse3: question.reponse3,
      reponse4: question.reponse4,
      verif: question.verif,
    }
    return this.http.post<Question>(QuestionService.URL, questionFormate, {
      headers: this.httpHeader,
    });
  }

  public update(question: Question): Observable<Question> {
    this.initHeader();
    return this.http.put<Question>(QuestionService.URL+ '/' + question.id, question, {
      headers: this.httpHeader,
    });
  }

}


