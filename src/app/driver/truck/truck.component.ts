import { Component, OnInit } from '@angular/core';
import { TruckService } from 'src/service/truck.service';
import { TruckDTO } from 'src/dto/truckdto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent'
import { DriverDTO } from 'src/dto/driverdto';
import { DriverService } from 'src/service/driver.service';

@Component({
  selector: 'app-truck',
  templateUrl: './truck.component.html',
  styleUrls: ['./truck.component.css']
})
export class TruckComponent extends AbstractCrudComponent<TruckDTO> implements OnInit {

  private currentUsertype: string;
  private driverlist: DriverDTO[];
  private driverId: number;

  constructor(service: TruckService, private driverService: DriverService) {
    super(service);
  }

  ngOnInit() {
    this.currentUsertype = JSON.parse(localStorage.getItem('currentUser')).usertype.toString();
    this.clear();

    if (this.currentUsertype === 'DRIVER') {
      this.driverId = JSON.parse(localStorage.getItem('currentUser')).driver.id;
      this.getAllByDriver(this.driverId);
    } else {
      this.getAll();
    }

    this.driverService.getAll().subscribe(driverlist => {

      driverlist.map(element => {
        delete element.user;
        delete element.truckList;
        return element;
      });// tolgo il campo user e trucklist che sono di troppo
      this.driverlist = driverlist;
    });

  }

  insert(dto: TruckDTO) {
    if (this.currentUsertype === 'DRIVER') {
      this.service.insert(dto).subscribe(() => this.getAllByDriver(this.driverId));
    } else {
      this.service.insert(dto).subscribe(() => this.getAll());
    }
  }

  delete(id: number) {
    if (this.currentUsertype === 'DRIVER') {
      this.service.delete(id).subscribe(() => this.getAllByDriver(this.driverId));
    } else {
      this.service.delete(id).subscribe(() => this.getAll());
    }
  }

  update(user: TruckDTO) {
    if (this.currentUsertype === 'DRIVER') {
      this.service.update(user).subscribe(() => this.getAllByDriver(this.driverId));
    } else {
      this.service.update(user).subscribe(() => this.getAll());
    }
  }

  clear() {
    this.dto = new TruckDTO();
    if (this.currentUsertype === 'DRIVER') {// Se sono driver lo setto in automatico
      this.dto.driver = JSON.parse(localStorage.getItem('currentUser')).driver;
    }
  }

  close() {
    this.selected = null;
  }

  compareFn(c1: TruckDTO, c2: TruckDTO): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  log(...val) { console.log(val); }

}
