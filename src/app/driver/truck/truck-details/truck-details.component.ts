import { Component, OnInit, Input } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { TruckService } from 'src/service/truck.service';
import { TruckDTO } from 'src/dto/truckdto';

@Component({
  selector: 'app-truck-details',
  templateUrl: './truck-details.component.html',
  styleUrls: ['../truck.component.css']
})
export class TruckDetailsComponent extends AbstractCrudComponent<TruckDTO> implements OnInit {

  @Input() dto: TruckDTO;

  constructor(service: TruckService) {
    super(service);
  }

  ngOnInit() {
  }

}
