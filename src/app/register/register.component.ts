import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { DriverDTO } from 'src/dto/driverdto';
import { PassengerDTO } from 'src/dto/passengerdto';
import { UserService } from 'src/service/user.service';
import { DriverService } from 'src/service/driver.service';
import { PassengerService } from 'src/service/passenger.service';
import { Usertype } from 'src/dto/usertype';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  driver: DriverDTO;
  passenger: PassengerDTO;
  dto: UserDTO;

  constructor(private service: UserService, private driverService: DriverService, private passengerService: PassengerService,
              private router: Router) { }

  ngOnInit() {
    this.clear();
  }

  clear() {
    this.dto = new UserDTO();
    this.driver = new DriverDTO();
    this.passenger = new PassengerDTO();

  }

  register(): void {

    this.service.insert(this.dto).subscribe((user) => {

      if (user.usertype.toString() === 'DRIVER') {
        this.driver.user = user;
        this.driverService.insert(this.driver).subscribe((driver) => { });

      } else if (user.usertype.toString() === 'PASSENGER') {
        this.passenger.user = user;
        this.passengerService.insert(this.passenger).subscribe((passenger) => { });
      }

    });

    this.router.navigate(['/login']);
  }

  cambia(usertype: Usertype): void {
    if (usertype.toString() === 'DRIVER') {
      document.querySelector('#hideDriver').setAttribute('style', 'display:block');
      document.querySelector('#hidePassenger').setAttribute('style', 'display:none');
    } else if (usertype.toString() === 'PASSENGER') {
      document.querySelector('#hideDriver').setAttribute('style', 'display:none');
      document.querySelector('#hidePassenger').setAttribute('style', 'display:block');
    }
  }

}