import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwoTruthsOneLieComponent } from './two-truths-one-lie.component';

describe('TwoTruthsOneLieComponent', () => {
  let component: TwoTruthsOneLieComponent;
  let fixture: ComponentFixture<TwoTruthsOneLieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwoTruthsOneLieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TwoTruthsOneLieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
