import { Quiz } from './../model/quiz';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private static URL = 'http://localhost:8081/boot/api/quiz';
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
    return this.http.get<Object[]>(QuizService.URL, {
      headers: this.httpHeader,
    });
  }

  public get(id: number): Observable<Quiz> {
    this.initHeader();
    return this.http.get<Quiz>(QuizService.URL+ '/' + id, {
      headers: this.httpHeader,
    });
  }

  public getWithQuestions(id: number): Observable<Quiz> {
    this.initHeader();
    return this.http.get<Quiz>(QuizService.URL+ '/' + id + '/question', {
      headers: this.httpHeader,
    });
  }

  public delete(id: number): Observable<void> {
    this.initHeader();
    return this.http.delete<void>(QuizService.URL+ '/' + id, {
      headers: this.httpHeader,
    });
  }

  public create(quiz: Quiz): Observable<Quiz> {
    this.initHeader();
    const quizFormate = {
      nom: quiz.nom,
      niveau: quiz.niveau,
      ranked: quiz.ranked,
      questions: quiz.questions,
    }
    return this.http.post<Quiz>(QuizService.URL, quizFormate, {
      headers: this.httpHeader,
    });
  }

  public update(quiz: Quiz): Observable<Quiz> {
    this.initHeader();
    return this.http.put<Quiz>(QuizService.URL+ '/' + quiz.id, quiz, {
      headers: this.httpHeader,
    });
  }
}
