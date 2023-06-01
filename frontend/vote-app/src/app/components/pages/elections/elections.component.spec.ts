import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ElectionsComponent } from './elections.component';

describe('ElectionsComponent', () => {
  let component: ElectionsComponent;
  let fixture: ComponentFixture<ElectionsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ElectionsComponent]
    });
    fixture = TestBed.createComponent(ElectionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
