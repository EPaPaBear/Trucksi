import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { HystorytravelDTO } from 'src/dto/hystorytraveldto';
import { HystorytravelService } from 'src/service/hystorytravel.service';
import { TEMPLATE_DRIVEN_DIRECTIVES } from '@angular/forms/src/directives';

@Component({
  selector: 'app-hystorytravel',
  templateUrl: './hystorytravel.component.html',
  styleUrls: ['../users/users.component.css']
})
export class HystorytravelComponent extends AbstractCrudComponent<HystorytravelDTO> implements OnInit {
  timearrival_s: string;
  timedeparture_s: string;
  constructor(service: HystorytravelService) {
    super(service);
  }
  dummyhtdata: HystorytravelDTO[];

  ngOnInit() {
    this.clear();
    this.dto = {
      id: 1,
      nometeam: 'eew',
      descrizione: 'qqq',
      numeroutent: 'test',
      numeroteam: '2',
      timedeparture: {
        hours: 18,
        minutes: 30

      },
      timearrival: {
        hours: 19,
        minutes: 30
      },
      truckDTO: null

      /*  "travel": {
            "id": 1,
            "date": "2020-06-11",
            "truck": null
        }, */

    };
    this.dummyhtdata = [ this.dto, this.dto, this.dto ];
    this.toInputTime(this.dto);
    for (const dtod of this.dummyhtdata){
      this.toInputTime(dtod);
      console.log(dtod);
    }
  }
  clear() {
    this.dto = new HystorytravelDTO();
  }
  toInputTime(dto) {
    dto.timearrival_s = this.dto.timearrival.hours + ':' + this.dto.timearrival.minutes;
    dto.timedeparture_s = this.dto.timedeparture.hours + ':' + this.dto.timedeparture.minutes;
  }

}
