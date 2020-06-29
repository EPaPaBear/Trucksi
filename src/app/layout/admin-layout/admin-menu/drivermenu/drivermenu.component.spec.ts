import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DrivermenuComponent } from './drivermenu.component';

describe('DrivermenuComponent', () => {
  let component: DrivermenuComponent;
  let fixture: ComponentFixture<DrivermenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DrivermenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DrivermenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
