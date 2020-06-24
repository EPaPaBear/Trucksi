import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { HystorytravelDTO } from 'src/dto/hystorytraveldto';
import { HystorytravelService } from 'src/service/hystorytravel.service';
import { TEMPLATE_DRIVEN_DIRECTIVES } from '@angular/forms/src/directives';
import { stringify } from 'querystring';

@Component({
  selector: 'app-hystorytravel',
  
  templateUrl: './hystorytravel.component.html',
  styleUrls: ['../users/users.component.css']
})
export class HystorytravelComponent extends AbstractCrudComponent<HystorytravelDTO> implements OnInit {
  timearrival_s: string;
  timedeparture_s: string;
  readonly lenghttime: number = 5;
  hts: HystorytravelDTO[];

  constructor(service: HystorytravelService) {
    super(service);
  }
  dummyhtdata: HystorytravelDTO[];
  ngOnInit() {
    this.clear();
    //this.getHystorytravels();
    this.getAll();
    console.log(this.dtolist);
  }
  clear(){
    this.dto = new HystorytravelDTO();
  }
  getHystorytravels() {
    this.service.getAll().subscribe(hts => this.hts = hts );
  }
  update_(dto) {
    /*if ( dto.timedeparture.length === this.lenghttime ) {
       dto.timedeparture =  dto.timedeparture + ':00';
     }*/
    dto.timedeparture = this.time_adapter(dto.timedeparture);
    dto.timearrival = this.time_adapter(dto.timearrival);
    console.log('here');
    this.update(dto);

  }

  time_adapter(time: string): string {
    if ( time.length === this.lenghttime ) {
      return time + ':00';
    }
    return time;
  }
  


  ngOnInit_() {
    this.clear();
    this.dto = {
      id: 1,
      nometeam: 'eew',
      descrizione: 'qqq',
      numeroutent: 'test',
      numeroteam: '2',
      timedeparture: '18',
      timearrival: '19',
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
  toInputTime(dto) {
  }

}
