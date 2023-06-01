import { Election } from './election';

export class ElectionResults {
  public id!: number;
  public election = new Election();
  public title = '';
  public votes = 0;
  public amountFemale = 0;
  public amountMale = 0;
  public result = Result;
}

enum Result {
  A,
  B,
}
