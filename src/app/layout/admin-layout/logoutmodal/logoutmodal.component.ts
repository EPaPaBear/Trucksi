import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logoutmodal',
  templateUrl: './logoutmodal.component.html',
  styleUrls: ['./logoutmodal.component.css']
})
export class LogoutmodalComponent implements OnInit {

  constructor(private router: Router) { }  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  ngOnInit() {
  }

}
