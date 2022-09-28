import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourtierdashboardComponent } from './courtierdashboard.component';

describe('CourtierdashboardComponent', () => {
  let component: CourtierdashboardComponent;
  let fixture: ComponentFixture<CourtierdashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CourtierdashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CourtierdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
