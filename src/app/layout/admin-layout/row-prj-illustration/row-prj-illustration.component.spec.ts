import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RowPrjIllustrationComponent } from './row-prj-illustration.component';

describe('RowPrjIllustrationComponent', () => {
  let component: RowPrjIllustrationComponent;
  let fixture: ComponentFixture<RowPrjIllustrationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RowPrjIllustrationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RowPrjIllustrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
