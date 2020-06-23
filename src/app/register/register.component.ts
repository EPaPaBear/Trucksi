import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { DriverDTO } from 'src/dto/driverdto';
import { PassengerDTO } from 'src/dto/passengerdto';
import { UserService } from 'src/service/user.service';
import { DriverService } from 'src/service/driver.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  // userDTO = new UserDTO();
  // passengerDTO = new PassengerDTO();
  //driverDTO = new DriverDTO();

  //private driverService = new DriverService();


  constructor(private service: UserService, private driverService: DriverService, private router: Router) { }

  ngOnInit() {
    this.clear();
    //this.getAll(); 
  }

  clear() {
    // this.dto = new UserDTO();

  }

  /*register(f: NgForm): void {
    console.log(f.value);
    this.userDTO.username = f.value.username;
    this.userDTO.password = f.value.password;
    this.userDTO.usertype = f.value.usertype;
    this.service.insert(this.userDTO).subscribe((user) => {
      console.log(user);
      this.driverDTO.user = user;
      this.passengerDTO.user = user;
    });
    if (f.value.usertype === "DRIVER") {
      this.driverDTO.name = f.value.nameD;
      this.driverDTO.surname = f.value.surnameD;
      this.driverDTO.phone = f.value.phoneD;
      this.driverDTO.driverLicense = f.value.driverLicense;
      this.driverDTO.age = f.value.ageD;
      console.log(this.driverDTO);
      this.driverService.insert(this.driverDTO).subscribe((driver) => {
        console.log(driver);
        this.userDTO.driver = driver;
      });
      //this.userDTO.driver = this.driverDTO;
    } else if (f.value.usertype === "PASSENGER") {
      this.passengerDTO.name = f.value.nameP;
      this.passengerDTO.surname = f.value.surnameP;
      this.passengerDTO.phone = f.value.phoneP;
      this.passengerDTO.age = f.value.ageP;
      this.userDTO.passenger = this.passengerDTO;
    }



    console.log(this.userDTO);

    console.log("submitted");

    //this.router.navigate(['/login']);
  }*/

  cambia(f: NgForm): void {
    console.log();
    let userType = f.value.usertype;
    if (userType === "DRIVER") {
      document.querySelector('#hideDriver').setAttribute("style", "display:block");
      document.querySelector('#hidePassenger').setAttribute("style", "display:none");
      console.log("driver");
    } else if (userType === "PASSENGER") {
      document.querySelector('#hideDriver').setAttribute("style", "display:none");
      document.querySelector('#hidePassenger').setAttribute("style", "display:block");
      console.log("passenger");
    }
    console.log("cambiato");
  }

}
