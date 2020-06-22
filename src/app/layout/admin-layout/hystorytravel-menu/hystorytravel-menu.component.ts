import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hystorytravel-menu',
  templateUrl: './hystorytravel-menu.component.html',
  styleUrls: ['../admin-menu/admin-menu.component.css']
})
export class HystorytravelMenuComponent implements OnInit {

  isHtCollapsed = false;
  constructor() { }

  ngOnInit() {
  }
  htcollapse(){
    this.isHtCollapsed = !this.isHtCollapsed;
  }

}
