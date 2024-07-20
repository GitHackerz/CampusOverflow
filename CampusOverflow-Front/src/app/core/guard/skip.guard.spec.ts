import { TestBed } from '@angular/core/testing';
import { CanActivateFn } from '@angular/router';

import { skipGuard } from './skip.guard';

describe('skipGuard', () => {
  const executeGuard: CanActivateFn = (...guardParameters) => 
      TestBed.runInInjectionContext(() => skipGuard(...guardParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeGuard).toBeTruthy();
  });
});
