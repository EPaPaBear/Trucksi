import { Component, OnInit, Input, OnChanges, DoCheck, ChangeDetectionStrategy } from '@angular/core';
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
  styleUrls: ['../users.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class UserDetailsComponent implements OnInit, OnChanges {

  private userType = Usertype;
  private userTypeOptions = [];
  private dtoUsertype: string;

  /**
   * Qui prende in input il valore di dto
   */
  @Input() dto: UserDTO;

  constructor(private service: UserService, private driverService: DriverService, private passengerService: PassengerService) { }

  ngOnInit() {
    this.userTypeOptions = Object.keys(this.userType).map(key => this.userType[key]).filter(value => typeof value === 'string');
  }

  // faccio questa funzione cosi ogni volta che cambia il dto che passo mi chiama questa funzione
  ngOnChanges() {
    // Mi creo una variabile che contiene se il dto passato è un driver o un passenger
    this.dtoUsertype = this.dto.usertype.toString();
    // creo l'istanza di driver o di passenger ,se non c'è, perchè quando vado a prendermi il valore mi da errore 
    // che non posso prendere n valore di un oggetto null
    if (this.dto.driver == null) {
      this.dto.driver = new DriverDTO();
    }
    if (this.dto.passenger == null) {
      this.dto.passenger = new PassengerDTO();
    }
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
    this.service.getAll();// Chiamo il get all cosi da fare un refresh di tutti gli elementi di dtolist
    const clickEvent = new CustomEvent('click');
    const btnElement = document.querySelector('#closeButton');
    btnElement.dispatchEvent(clickEvent);
  }


}
