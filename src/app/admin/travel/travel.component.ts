import { Component, OnInit } from '@angular/core';
import { TravelService } from 'src/service/travel.service';
import { TruckService } from 'src/service/truck.service';
import { TravelDTO } from 'src/dto/traveldto';
import { TruckDTO } from 'src/dto/truckdto';
import { Router } from '@angular/router';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';


@Component({
  selector: 'app-travel',
  templateUrl: './travel.component.html',
  styleUrls: ['./travel.component.css'],
  providers: [TravelService, TruckService]
})

export class TravelComponent  extends  AbstractCrudComponent<TravelDTO> implements OnInit {
  
  travels: TravelDTO[];
  trucks: TruckDTO[];
  travelinsert: TravelDTO = new TravelDTO();
  truck : TruckDTO;


  constructor(private travelService: TravelService, private truckService: TruckService, private router: Router) {
    super(travelService);
   }

  ngOnInit() {

   this.getTravels();
    this.getTrucks();
  }

  getTravels(){
   this.travelService.getAll().subscribe(travels => this.travels = travels);
  }

  getTrucks(){
    this.truckService.getAll().subscribe(trucks => this.trucks = trucks);
  }

  insert(travel: TravelDTO){
    this.truck = this.travelinsert.truckDTO;
    travel.truckDTO = this.truck;
    this.travelService.insert(travel).subscribe(() => this.getTravels());
    this.clear();
  }

/*
  delete(travel:TravelDTO){
    this.travelService.delete(travel.id).subscribe(() => this.getTravels());
  }
*/
  
  getTravel(travel: TravelDTO){
    localStorage.setItem('Travel', JSON.stringify(travel));
    this.router.navigate(['/admin-dashboard/notifications']);
  }
  

  clear(){
    this.travelinsert = new TravelDTO();
  }

}

