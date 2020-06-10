import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewallcentersComponent } from './viewallcenters.component';

describe('ViewallcentersComponent', () => {
  let component: ViewallcentersComponent;
  let fixture: ComponentFixture<ViewallcentersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewallcentersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewallcentersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
