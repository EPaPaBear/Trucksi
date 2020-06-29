import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-sidebarbrand',
  templateUrl: './sidebarbrand.component.html',
  styleUrls: ['./sidebarbrand.component.css']
})
export class SidebarbrandComponent implements OnInit {

  user: UserDTO;

  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

}
