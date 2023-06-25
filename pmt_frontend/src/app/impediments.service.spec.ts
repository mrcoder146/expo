import { TestBed } from '@angular/core/testing';

import { ImpedimentsService } from './impediments.service';

describe('ImpedimentsService', () => {
  let service: ImpedimentsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImpedimentsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
