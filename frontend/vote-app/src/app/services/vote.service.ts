import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vote } from '../dataaccess/vote';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class VoteService {
  readonly backendUrl = 'vote';

  constructor(private http: HttpClient) {}

  public getList(): Observable<Vote[]> {
    return this.http.get<Vote[]>(environment.backendBaseUrl + this.backendUrl);
  }

  public getOne(id: number): Observable<Vote> {
    return this.http.get<Vote>(
      environment.backendBaseUrl + this.backendUrl + `/${id}`
    );
  }

  public update(vote: Vote): Observable<Vote> {
    return this.http.put<Vote>(
      environment.backendBaseUrl + this.backendUrl + `/${vote.id}`,
      vote
    );
  }

  public save(vote: Vote): Observable<Vote> {
    return this.http.post<Vote>(
      environment.backendBaseUrl + this.backendUrl,
      vote
    );
  }

  public delete(id: number): Observable<HttpResponse<string>> {
    return this.http.delete<string>(
      environment.backendBaseUrl + this.backendUrl + `/${id}`,
      { observe: 'response' }
    );
  }
}
