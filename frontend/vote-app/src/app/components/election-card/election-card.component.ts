import { Component, OnInit } from '@angular/core';
import { ElectionService } from 'src/app/services/election.service';
import { Election } from 'src/app/dataaccess/election';

@Component({
  selector: 'app-election-card',
  templateUrl: './election-card.component.html',
  styleUrls: ['./election-card.component.scss'],
})
export class ElectionCardComponent implements OnInit {
  electionData: Election = {} as Election;

  ngOnInit() {
    const electionService = new ElectionService();
    electionService.getElections().subscribe((response) => {
      this.electionData = response;
      console.log(response);
    });
  }
}
