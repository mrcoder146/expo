import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImpedimentsComponent } from './impediments.component';

describe('ImpedimentsComponent', () => {
  let component: ImpedimentsComponent;
  let fixture: ComponentFixture<ImpedimentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImpedimentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImpedimentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
