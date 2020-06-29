import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrevelmenuComponent } from './trevelmenu.component';

describe('TrevelmenuComponent', () => {
  let component: TrevelmenuComponent;
  let fixture: ComponentFixture<TrevelmenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrevelmenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrevelmenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
