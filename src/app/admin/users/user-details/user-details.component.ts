import { Component, OnInit, Input } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { Usertype } from 'src/dto/usertype';
import { PassengerDTO } from 'src/dto/passengerdto';
import { PassengerService } from 'src/service/passenger.service';
import { DriverDTO } from 'src/dto/driverdto';
import { DriverService } from 'src/service/driver.service';

/**
 * Questa component si occupa di mostrare i dettagli di un utente (in questo caso aggiunge solo l'ID
 * alle informazioni già mostrate nella tabella generale). L'annotation "@Input()" prende il valore di dto
 * dalla UsersComponent ( usando il binding [dto]) e nel template ne mostra i dettagli. Questa component 
 * non viene chiamata mediante routing ma viene mostrata solo quando dto non è nullo (usando la direttiva
 * *ngIf ).
 * 
 * @author Vittorio Valent
 * 
 * @see UsersComponent
 */
@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['../users.component.css']
})
export class UserDetailsComponent implements OnInit {

  private userType = Usertype;
  public userTypeOptions = [];

  /**
   * Qui prende in input il valore di dto
   */
  @Input() dto: UserDTO;

  constructor(private service: UserService, private driverService: DriverService, private passengerService: PassengerService) { }

  ngOnInit() {
    console.log(this.dto);
    if (this.dto.driver == null) {
      this.dto.driver = new DriverDTO();
    }
    if (this.dto.passenger == null) {
      this.dto.passenger = new PassengerDTO();
    }
    this.userTypeOptions = Object.keys(this.userType).map(key => this.userType[key]).filter(value => typeof value === 'string');
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => this.service.getAll());
  }

  update(user: UserDTO) {
    const userDTOMoment = new UserDTO();
    userDTOMoment.id = user.id;

    if (user.usertype.toString() === 'DRIVER') {
      user.driver.user = userDTOMoment;
      this.driverService.update(user.driver).subscribe(() => this.close());
    } else if (user.usertype.toString() === 'PASSENGER') {
      user.passenger.user = userDTOMoment;
      this.passengerService.update(user.passenger).subscribe(() => this.close());
    }
  }

  close() {
    const clickEvent = new CustomEvent('click');
    const btnElement = document.querySelector('#closeButton');
    btnElement.dispatchEvent(clickEvent);
  }

}
