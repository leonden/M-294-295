import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Election } from '../dataaccess/election';
import { ELECTION_BASE_URL } from '../utils';
import axios from 'axios';

@Injectable({
  providedIn: 'root',
})
export class ElectionFormService {
  saveElection(election: Election): Observable<Election> {
    return new Observable((observer) => {
      axios
        .post(`${ELECTION_BASE_URL}`, election)
        .then((response) => {
          observer.next(response.data);
          observer.complete();
        })
        .catch((error) => {
          observer.error(error);
        });
    });
  }
}
