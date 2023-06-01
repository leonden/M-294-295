import { Injectable } from '@angular/core';
import axios from 'axios';
import { ELECTION_BASE_URL } from 'src/app/utils';
import { Observable } from 'rxjs';
import { Election } from 'src/app/dataaccess/election';

@Injectable({
  providedIn: 'root',
})
export class ElectionOverviewService {
  getElections(): Observable<Election> {
    return new Observable((observer) => {
      axios
        .get(`${ELECTION_BASE_URL}`)
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
