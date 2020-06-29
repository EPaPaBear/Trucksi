import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HystorytravelmenuComponent } from './hystorytravelmenu.component';

describe('HystorytravelmenuComponent', () => {
  let component: HystorytravelmenuComponent;
  let fixture: ComponentFixture<HystorytravelmenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HystorytravelmenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HystorytravelmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
