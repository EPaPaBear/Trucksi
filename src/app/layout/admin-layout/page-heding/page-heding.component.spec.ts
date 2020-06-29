import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PageHedingComponent } from './page-heding.component';

describe('PageHedingComponent', () => {
  let component: PageHedingComponent;
  let fixture: ComponentFixture<PageHedingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PageHedingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PageHedingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
