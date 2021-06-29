import { TestBed } from '@angular/core/testing';

import { ConnGuard } from './conn.guard';

describe('ConnGuard', () => {
  let guard: ConnGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(ConnGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
