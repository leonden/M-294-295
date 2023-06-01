export class Person {
  public id!: number;
  public firstName = '';
  public lastName = '';
  public sex = Sex;
  public adult = false;
  public age = 0;
  public street = '';
  public city = '';
  public zipCode = '';
}

export enum Sex {
  MALE,
  FEMALE,
}
