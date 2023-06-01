import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Election } from '../dataaccess/election';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ElectionService {
  readonly backendUrl = 'election';

  constructor(private http: HttpClient) {}

  public getList(): Observable<Election[]> {
    return this.http.get<Election[]>(
      environment.backendBaseUrl + this.backendUrl
    );
  }

  public getOne(id: number): Observable<Election> {
    return this.http.get<Election>(
      environment.backendBaseUrl + this.backendUrl + `/${id}`
    );
  }

  public update(election: Election): Observable<Election> {
    return this.http.put<Election>(
      environment.backendBaseUrl + this.backendUrl + `/${election.id}`,
      election
    );
  }

  public save(election: Election): Observable<Election> {
    return this.http.post<Election>(
      environment.backendBaseUrl + this.backendUrl,
      election
    );
  }

  public delete(id: number): Observable<HttpResponse<string>> {
    return this.http.delete<string>(
      environment.backendBaseUrl + this.backendUrl + `/${id}`,
      { observe: 'response' }
    );
  }
}
