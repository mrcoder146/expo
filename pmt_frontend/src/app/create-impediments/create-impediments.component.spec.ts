import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateImpedimentsComponent } from './create-impediments.component';

describe('CreateImpedimentsComponent', () => {
  let component: CreateImpedimentsComponent;
  let fixture: ComponentFixture<CreateImpedimentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateImpedimentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateImpedimentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
