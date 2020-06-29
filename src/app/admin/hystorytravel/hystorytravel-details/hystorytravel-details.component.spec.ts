import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HystorytravelDetailsComponent } from './hystorytravel-details.component';

describe('HystorytravelDetailsComponent', () => {
  let component: HystorytravelDetailsComponent;
  let fixture: ComponentFixture<HystorytravelDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HystorytravelDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HystorytravelDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
