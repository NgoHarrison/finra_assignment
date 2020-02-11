import { TestBed } from '@angular/core/testing';

import { NumberserviceService } from './numberservice.service';

describe('NumberserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NumberserviceService = TestBed.get(NumberserviceService);
    expect(service).toBeTruthy();
  });
});
