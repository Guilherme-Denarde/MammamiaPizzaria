import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddressdetailsComponent } from './addressdetails.component';

describe('AddressdetailsComponent', () => {
  let component: AddressdetailsComponent;
  let fixture: ComponentFixture<AddressdetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddressdetailsComponent]
    });
    fixture = TestBed.createComponent(AddressdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
