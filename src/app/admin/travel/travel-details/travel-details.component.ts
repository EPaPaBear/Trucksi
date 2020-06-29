import { Component, OnInit, Input } from '@angular/core';
import { TravelDTO } from 'src/dto/traveldto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { TravelService } from 'src/service/travel.service';
import { TruckService } from 'src/service/truck.service';
import { HttpClient } from '@angular/common/http';
import { TruckDTO } from 'src/dto/truckdto';

@Component({
  selector: 'app-hystorytravel-details',
  templateUrl: './hystorytravel-details.component.html',
  styleUrls: ['../hystorytravel.component.css']
})
export class TravelDetailsComponent extends AbstractCrudComponent<TravelDTO> implements OnInit {
  @Input() dto: TravelDTO;
  TruckDTO: TruckDTO[];

  constructor(service: TravelService) {
    super(service);

  }

  ngOnInit() {
   

    console.log(this.dto );
  }

}
