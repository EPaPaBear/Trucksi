import { Component, OnInit } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { HystorytravelDTO } from 'src/dto/hystorytraveldto';
import { UserService } from 'src/service/user.service';
import { HystorytravelService } from 'src/service/hystorytravelservice';

@Component({
  selector: 'app-hystorytravel',
  templateUrl: './hystorytravel.component.html',
  styleUrls: ['./hystorytravel.component.css']
})
export class HystorytravelComponent extends AbstractCrudComponent<HystorytravelDTO> implements OnInit {

  constructor(service: HystorytravelService) { 
    super(service);
  }

  ngOnInit() {
    this.clear();
    this.dto = {
      "id": 1,
      "nometeam": "eew",
      "descrizione": "qqq",
     "numeroutent": "test",
      "numeroteam": "2",
      "timedeparture": { 
        'hours': 18,
        'minutes': 30

      },
      "timearrival": { 
        'hours': 18,
        'minutes': 30
      }, 
      "truckDTO" : null
    
    /*  "travel": {
          "id": 1,
          "date": "2020-06-11",
          "truck": null
      }, */
      
    }
  }
  clear() {
    this.dto = new HystorytravelDTO();
  }

}
