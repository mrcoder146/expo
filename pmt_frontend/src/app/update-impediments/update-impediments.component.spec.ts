import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateImpedimentsComponent } from './update-impediments.component';

describe('UpdateImpedimentsComponent', () => {
  let component: UpdateImpedimentsComponent;
  let fixture: ComponentFixture<UpdateImpedimentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateImpedimentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateImpedimentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
