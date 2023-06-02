import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Person } from '../dataaccess/person';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class PersonService {
  readonly backendUrl = 'person';

  constructor(private http: HttpClient) {}

  public getList(): Observable<Person[]> {
    return this.http.get<Person[]>(
      environment.backendBaseUrl + this.backendUrl
    );
  }

  public getOne(id: number): Observable<Person> {
    return this.http.get<Person>(
      environment.backendBaseUrl + this.backendUrl + `/${id}`
    );
  }

  public update(person: Person): Observable<Person> {
    return this.http.put<Person>(
      environment.backendBaseUrl + this.backendUrl + `/${person.id}`,
      person
    );
  }

  public save(person: Person): Observable<Person> {
    return this.http.post<Person>(
      environment.backendBaseUrl + this.backendUrl,
      person
    );
  }

  public delete(id: number): Observable<HttpResponse<string>> {
    return this.http.delete<string>(
      environment.backendBaseUrl + this.backendUrl + `/${id}`,
      { observe: 'response' }
    );
  }
}
