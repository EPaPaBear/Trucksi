import { Component, OnInit } from '@angular/core';
import { DriverDTO } from 'src/dto/driverdto';

@Component({
  selector: 'app-driver-dashboard',
  templateUrl: './driver-dashboard.component.html',
  styleUrls: ['./driver-dashboard.component.css']
})
export class DriverDashboardComponent implements OnInit {

  driver: DriverDTO;

  constructor() { }

  ngOnInit() {
    this.driver = JSON.parse(localStorage.getItem('currentUser')).driver;
  }

}
