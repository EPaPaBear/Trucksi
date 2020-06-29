import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarbrandComponent } from './sidebarbrand.component';

describe('SidebarbrandComponent', () => {
  let component: SidebarbrandComponent;
  let fixture: ComponentFixture<SidebarbrandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SidebarbrandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarbrandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
