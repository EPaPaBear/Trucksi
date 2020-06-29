import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherslayoutcomponentComponent } from './otherslayoutcomponent.component';

describe('OtherslayoutcomponentComponent', () => {
  let component: OtherslayoutcomponentComponent;
  let fixture: ComponentFixture<OtherslayoutcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtherslayoutcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherslayoutcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
