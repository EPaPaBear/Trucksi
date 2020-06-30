import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { Usertype } from 'src/dto/usertype';

/**
 * Come ogni componente di CRUD, questa estende la classe AbstractCrudComponent, ereditando tutti i metodi 
 * per le CRUD. Questo ci permette di non riscrivere ogni volta gli stessi metodi e avere meno errori.
 * @author Vittorio Valent
 * 
 * @see AbstractCrudComponent
 */

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent extends AbstractCrudComponent<UserDTO> implements OnInit {

  private userType = Usertype;
  public userTypeOptions = [];
  private currentUsertype: string;
  private driverId: number;
  private hideInsert: boolean;

  constructor(service: UserService) {
    super(service);
  }

  ngOnInit() {
    this.currentUsertype = JSON.parse(localStorage.getItem('currentUser')).usertype.toString();
    this.clear();

    if (this.currentUsertype === 'DRIVER') {
      this.hideInsert = true;
      this.driverId = JSON.parse(localStorage.getItem('currentUser')).driver.id;
      this.service.read(this.driverId).subscribe(user => {
        this.dtolist = new Array();
        delete user.passenger;
        delete user.driver;
        this.dtolist.push(user);
      });
    } else {
      this.hideInsert = false;
      this.service.getAll().subscribe(dtolist => {
        dtolist.map(element => {
          delete element.passenger;
          delete element.driver;
        })
        this.dtolist = dtolist;
      });
    }

    // Below line extracts all the keys from the enum 
    this.userTypeOptions = Object.keys(this.userType).map(key => this.userType[key]).filter(value => typeof value === 'string');
  }

  toggleActive(dto) {
    dto.active = !dto.active;
    dto.passenger = null;
    dto.driver = null;
    this.update(dto);
  }

  clear() {
    this.dto = new UserDTO();

  }

  select(dto: UserDTO) {
    this.service.read(dto.id).subscribe(user => this.selected = user);
  }

  update(user: UserDTO) {
    if (this.currentUsertype === 'DRIVER') {
      this.service.update(user).subscribe(() => {
        this.service.read(this.driverId).subscribe(userI => {
          this.dtolist = new Array();
          delete userI.passenger;
          delete userI.driver;
          this.dtolist.push(userI);
        });
      });
    } else {
      this.service.update(user).subscribe(() => {
        this.service.getAll().subscribe(dtolist => {
          dtolist.map(element => {
            delete element.passenger;
            delete element.driver;
          })
          this.dtolist = dtolist;
        });
      });
    }

  }

  close() {
    this.selected = null;
  }

}