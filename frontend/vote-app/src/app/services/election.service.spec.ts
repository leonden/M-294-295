import { TestBed } from '@angular/core/testing';

import { ElectionService } from './election.service';
import { createSpyFromClass, Spy } from 'jasmine-auto-spies';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Election } from '../dataaccess/election';

describe('ElectionService', () => {
  let service: ElectionService;
  let httpSpy: Spy<HttpClient>;

  const fakeElections: Election[] = [
    {
      id: 1,
      title: 'Election 1',
      description: 'Election 1 description',
      progress: 0,
    },
    {
      id: 2,
      title: 'Election 2',
      description: 'Election 2 description',
      progress: 0,
    },
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        { provide: HttpClient, useValue: createSpyFromClass(HttpClient) },
      ],
    });
    service = TestBed.inject(ElectionService);
    httpSpy = TestBed.inject<any>(HttpClient);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  it('should return a list of elections', (done: DoneFn) => {
    httpSpy.get.and.nextWith(fakeElections);

    service.getList().subscribe({
      next: (elections) => {
        expect(elections).toHaveSize(fakeElections.length);
        done();
      },
      error: done.fail,
    });
    expect(httpSpy.get.calls.count()).toBe(1);
  });
  it('should create a new election', (done: DoneFn) => {
    const newElection: Election = {
      id: 3,
      title: 'Election 3',
      description: 'Election 3 description',
      progress: 0,
    };

    httpSpy.post.and.nextWith(newElection);

    service.save(newElection).subscribe({
      next: (election) => {
        expect(election).toEqual(newElection);
        done();
      },
      error: done.fail,
    });
    expect(httpSpy.post.calls.count()).toBe(1);
  });

  it('should update an election', (done: DoneFn) => {
    const election = fakeElections[0];
    election.title = 'Updated Election';

    httpSpy.put.and.nextWith(election);

    service.update(election).subscribe({
      next: (election) => {
        expect(election.title).toEqual('Updated Election');
        done();
      },
      error: done.fail,
    });
    expect(httpSpy.put.calls.count()).toBe(1);
  });

  it('should delete an existing election', (done: DoneFn) => {
    httpSpy.delete.and.nextWith(
      new HttpResponse({
        status: 200,
      })
    );

    service.delete(1).subscribe({
      next: (response) => {
        expect(response.status).toBe(200);
        done();
      },
      error: done.fail,
    });
    expect(httpSpy.delete.calls.count()).toBe(1);
  });
});
