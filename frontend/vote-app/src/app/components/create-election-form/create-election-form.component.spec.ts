import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateElectionFormComponent } from './create-election-form.component';

describe('CreateElectionFormComponent', () => {
  let component: CreateElectionFormComponent;
  let fixture: ComponentFixture<CreateElectionFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateElectionFormComponent]
    });
    fixture = TestBed.createComponent(CreateElectionFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
