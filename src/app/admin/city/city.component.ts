import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { UserDTO } from 'src/dto/userdto';
import { CityService } from 'src/service/city.service';
import { CityDTO } from 'src/dto/citydto';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.css']
})
export class CityComponent extends AbstractCrudComponent<CityDTO> implements OnInit {

  constructor(service: CityService) {
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.getAll();
  }

  clear() {
    this.dto = new CityDTO();
  }

}
