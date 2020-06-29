import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TruckmenuComponent } from './truckmenu.component';

describe('TruckmenuComponent', () => {
  let component: TruckmenuComponent;
  let fixture: ComponentFixture<TruckmenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TruckmenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TruckmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
