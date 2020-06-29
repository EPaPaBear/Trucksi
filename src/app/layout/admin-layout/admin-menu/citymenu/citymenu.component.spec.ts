import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CitymenuComponent } from './citymenu.component';

describe('CitymenuComponent', () => {
  let component: CitymenuComponent;
  let fixture: ComponentFixture<CitymenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CitymenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CitymenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
