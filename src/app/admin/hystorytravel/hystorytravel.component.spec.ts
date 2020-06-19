import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HystorytravelComponent } from './hystorytravel.component';

describe('HystorytravelComponent', () => {
  let component: HystorytravelComponent;
  let fixture: ComponentFixture<HystorytravelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HystorytravelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HystorytravelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
