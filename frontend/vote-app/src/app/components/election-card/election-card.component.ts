import { Component, OnInit } from '@angular/core';
import { Election } from 'src/app/dataaccess/election';
import { ElectionOverviewService } from 'src/app/services/election-overview.service';

@Component({
  selector: 'app-election-card',
  templateUrl: './election-card.component.html',
  styleUrls: ['./election-card.component.scss'],
})
export class ElectionCardComponent implements OnInit {
  electionData: Election = {} as Election;

  ngOnInit() {
    const electionOverviewService = new ElectionOverviewService();
    electionOverviewService.getElections().subscribe((response) => {
      this.electionData = response;
      console.log(response);
    });
  }
}
