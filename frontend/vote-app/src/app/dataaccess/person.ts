export class Person {
  public id!: number;
  public firstName = '';
  public lastName = '';
  public sex = Sex;
  public adult = '';
  public age = '';
  public street = '';
  public city = '';
  public zipCode = '';
}

enum Sex {
  MALE,
  FEMALE,
}
