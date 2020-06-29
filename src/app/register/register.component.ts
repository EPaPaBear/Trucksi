import { UserDTO } from './../../dto/userdto';
import { Component, OnInit } from '@angular/core';
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
  driverhidden: boolean = false;
  passengerhidden: boolean = false;

  constructor(private service: UserService, private driverService: DriverService, private passengerService: PassengerService,
              private router: Router) { }

  ngOnInit() {
   // this.typingCallback(this);
    const body = document.getElementsByTagName('body')[0];
    body.classList.add('bg-gradient-primary');
    this.clear();
  }
  ngOnDestroy() {
    const body = document.getElementsByTagName('body')[0];
    body.classList.remove('bg-gradient-primary');
  }

  clear() {
    this.dto = new UserDTO();
    this.driver = new DriverDTO();
    this.passenger = new PassengerDTO();

  }

  register(): void {
    this.dto.id = null;

    this.service.insert(this.dto).subscribe((user) => {

      if (user.usertype.toString() === 'DRIVER') {
        this.driver.user = user;
        this.driver.id = null;
        this.driverService.insert(this.driver).subscribe((driver) => { });

      } else if (user.usertype.toString() === 'PASSENGER') {
        this.passenger.user = user;
        this.passenger.id = null;
        this.passengerService.insert(this.passenger).subscribe((passenger) => { });
      }

    });

    this.router.navigate(['/login']);
  }

  cambia(usertype: Usertype): void {
    if (usertype.toString() === 'DRIVER') {
      this.driverhidden = true;
      this.passengerhidden = false;
  //    document.querySelector('#hideDriver').setAttribute('style', 'display:block');
  //    document.querySelector('#hidePassenger').setAttribute('style', 'display:none');
    } else if (usertype.toString() === 'PASSENGER') {
      this.passengerhidden = true;
      this.driverhidden = false;
  //    document.querySelector('#hideDriver').setAttribute('style', 'display:none');
  //    document.querySelector('#hidePassenger').setAttribute('style', 'display:block');
    }
  }

}
