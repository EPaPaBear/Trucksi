import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-driver-menu',
  templateUrl: './driver-menu.component.html',
  styleUrls: ['./driver-menu.component.css']
})
export class DriverMenuComponent implements OnInit {


  isAccountCollapsed = false;
  idTruckCollapsed = false;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  accountcollapse() {
    this.isAccountCollapsed = !this.isAccountCollapsed;
  }

  truckcollapse() {
    this.idTruckCollapsed = !this.idTruckCollapsed;
  }

}
