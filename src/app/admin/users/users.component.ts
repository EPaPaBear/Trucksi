import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { Usertype } from 'src/dto/usertype';

/**
 * Come ogni componente di CRUD, questa estende la classe AbstractCrudComponent, ereditando tutti i metodi 
 * per le CRUD. Questo ci permette di non riscrivere ogni volta gli stessi metodi e avere meno errori.
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractCrudComponent
 * 
 */
@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent extends AbstractCrudComponent<UserDTO> implements OnInit {

  private userType = Usertype;
  public userTypeOptions = [];

  constructor(service: UserService) {
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.getAll();
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

  close() {
    this.selected = null;
  }
}
