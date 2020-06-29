import { Component, OnInit } from '@angular/core';
import { TruckService } from 'src/service/truck.service';
import { TruckDTO } from 'src/dto/truckdto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { DriverDTO } from 'src/dto/driverdto';

@Component({
  selector: 'app-truck',
  templateUrl: './truck.component.html',
  styleUrls: ['./truck.component.css']
})
export class TruckComponent extends AbstractCrudComponent<TruckDTO> implements OnInit {
iduser: number;
  constructor(service: TruckService) {
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.getAll();
  }

  clear() {
    this.dto = new TruckDTO();
    this.iduser = JSON.parse(localStorage.getItem('currentUser')).id;
  }

  close() {
    this.selected = null;
  }
  insert_2(dto) {
    dto.id = null;
    dto.user = { id: this.iduser};
    console.log(dto);
    this.insert(dto);
  }

  log(val) { console.log(val); }

}
