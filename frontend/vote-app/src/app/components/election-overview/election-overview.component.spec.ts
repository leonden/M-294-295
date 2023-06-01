import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElectionOverviewComponent } from './election-overview.component';

describe('ElectionOverviewComponent', () => {
  let component: ElectionOverviewComponent;
  let fixture: ComponentFixture<ElectionOverviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ElectionOverviewComponent]
    });
    fixture = TestBed.createComponent(ElectionOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
