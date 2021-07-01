import { Observable } from 'rxjs';
import { Score } from './../model/score';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ScoreService {
  private static URL = 'http://localhost:8081/boot/api/score';
  private httpHeader: HttpHeaders = new HttpHeaders();

  constructor(private http: HttpClient) {}

  private initHeader() {
    const auth = localStorage.getItem('auth');
    this.httpHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: auth ? auth : '',
    });
  }

  public create(score: Score, idQuiz: number): Observable<Score> {
    this.initHeader();
    const scoreFormate = {
      //scoreKey: score.scoreKey,
      value: score.value,
    };
    return this.http.post<Score>(
      ScoreService.URL + '/' + idQuiz,
      scoreFormate,
      {
        headers: this.httpHeader,
      }
    );
  }
}
