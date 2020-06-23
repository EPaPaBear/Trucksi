import { Component, OnInit } from '@angular/core';
import { TruckService } from 'src/service/truck.service';
import { TruckDTO } from 'src/dto/truckdto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent'
import { DriverDTO } from 'src/dto/driverdto';

@Component({
  selector: 'app-truck',
  templateUrl: './truck.component.html',
  styleUrls: ['./truck.component.css']
})
export class TruckComponent extends AbstractCrudComponent<TruckDTO> implements OnInit {

  constructor(service: TruckService) {
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.getAll();
  }

  clear() {
    this.dto = new TruckDTO();
    this.dto.driver = JSON.parse(localStorage.getItem('currentUser')).driver;
  }

  close() {
    this.selected = null;
  }

  log(val) { console.log(val); }

}
