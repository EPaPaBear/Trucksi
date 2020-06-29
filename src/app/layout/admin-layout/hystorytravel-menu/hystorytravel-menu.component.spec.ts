import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HystorytravelMenuComponent } from './hystorytravel-menu.component';

describe('HystorytravelMenuComponent', () => {
  let component: HystorytravelMenuComponent;
  let fixture: ComponentFixture<HystorytravelMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HystorytravelMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HystorytravelMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
