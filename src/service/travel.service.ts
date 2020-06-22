import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { TravelDTO } from 'src/dto/traveldto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TruckDTO } from 'src/dto/truckdto'; 

@Injectable({
  providedIn: 'root'
})
export class TravelService extends AbstractService<TravelDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'travel';
   }

   getAllById(truckDTO: TruckDTO): Observable<TravelDTO[]>{
     return this.http.post<TravelDTO[]>('http://localhost:8080/'+ this.type + '/getallbytruck', truckDTO);
   }
}
