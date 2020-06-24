 import { Component, OnInit } from '@angular/core';
import { TruckService } from 'src/service/truck.service';
import { TravelService } from 'src/service/travel.service';
import { TravelDTO } from 'src/dto/traveldto';
import { TruckDTO } from 'src/dto/truckdto';
import { Router } from '@angular/router';

@Component({
  selector: 'app-events',
  templateUrl: './travel.component.html',
  styleUrls: ['./travel.component.css'],
  providers: [TravelService, TruckService]
})

export class TravelComponent implements OnInit {

  travels: TravelDTO[];
  trucks: TruckDTO[];
  travelinsert: TravelDTO = new TravelDTO();
  truck : TruckDTO;

  constructor(private truckService: TruckService, private travelService: TravelService, private router: Router) { }

  ngOnInit() {
    this.getTrucks();
    this.getTravels();
   
  }

  getTravels(){
   this.travelService.getAll().subscribe(travels => this.travels = travels);
  }

  getTrucks(){
    this.truckService.getAll().subscribe(trucks => this.trucks = trucks);
  }


  insert(travel: TravelDTO){
    travel.id = 6;
    this.truck = this.travelinsert.truckDTO;
    travel.truckDTO = this.truck;
    this.travelService.insert(travel).subscribe(() => this.getTravels());
    this.clear();
  }


 delete(travel:TravelDTO){

    this.travelService.delete(travel.id).subscribe(() => this.getTravels());
  }
  
  getTravel(travel: TravelDTO){
    localStorage.setItem('Travel', JSON.stringify(travel));
    this.router.navigate(['/admin-dashboard/notifications']);
  }
  

  clear(){
    this.travelinsert = new TravelDTO();
  }
}


/*
import { TruckService } from 'src/service/truck.service';
import { TravelService } from 'src/service/travel.service';
import { TravelDTO } from 'src/dto/traveldto';
import { TruckDTO } from 'src/dto/truckdto';
import { Router } from '@angular/router';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { Component, OnInit } from '@angular/core';

/**
 * Come ogni componente di CRUD, questa estende la classe AbstractCrudComponent, ereditando tutti i metodi 
 * per le CRUD. Questo ci permette di non riscrivere ogni volta gli stessi metodi e avere meno errori.
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractCrudComponent
 * 
 */
/*
@Component({
  selector: 'app-travel',
  templateUrl: './travel.component.html',
  styleUrls: ['./travel.component.css'],
  providers: [TravelService, TruckService]
})

export class TravelComponent  extends AbstractCrudComponent <TravelDTO> implements OnInit {

  travels: TravelDTO[];
  trucks: TruckDTO[];
  travelinsert: TravelDTO = new TravelDTO();
  truck : TruckDTO;


  
  constructor(travelService: TravelService) {
    super(travelService);
  }

  ngOnInit() {
    this.clear();
    this.getAll();
    // Below line extracts all the keys from the enum 
   // this.userTypeOptions = Object.keys(this.userType).map(key => this.userType[key]).filter(value => typeof value === 'string');
  }


  clear() {
    this.dto = new TravelDTO();

  }
  close() {
    this.selected = null;
  }
}
*/