import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElectionCardComponent } from './election-card.component';

describe('ElectionCardComponent', () => {
  let component: ElectionCardComponent;
  let fixture: ComponentFixture<ElectionCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ElectionCardComponent]
    });
    fixture = TestBed.createComponent(ElectionCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
