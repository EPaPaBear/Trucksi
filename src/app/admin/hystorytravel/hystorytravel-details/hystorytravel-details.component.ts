import { Component, OnInit, Input } from '@angular/core';
import { HystorytravelDTO } from 'src/dto/hystorytraveldto';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { HystorytravelService } from 'src/service/hystorytravel.service';
import { TruckService } from 'src/service/truck.service';
import { HttpClient } from '@angular/common/http';
import { TruckDTO } from 'src/dto/truckdto';

@Component({
  selector: 'app-hystorytravel-details',
  templateUrl: './hystorytravel-details.component.html',
  styleUrls: ['../hystorytravel.component.css']
})
export class HystorytravelDetailsComponent extends AbstractCrudComponent<HystorytravelDTO> implements OnInit {
  @Input() dto: HystorytravelDTO;
  TruckDTO: TruckDTO[];

  constructor(service: HystorytravelService) {
    super(service);

  }

  ngOnInit() {
   

    console.log(this.dto );
  }

}
