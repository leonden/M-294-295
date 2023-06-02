import { Component } from '@angular/core';
import { ElectionFormService } from 'src/app/services/election-form.service';

@Component({
  selector: 'app-create-election-form',
  templateUrl: './create-election-form.component.html',
  styleUrls: ['./create-election-form.component.scss'],
})
export class CreateElectionFormComponent {
  constructor(private electionFormService: ElectionFormService) {}

  onSubmit(electionForm: any) {
    this.electionFormService.saveElection(electionForm.value).subscribe(
      (data) => {
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
