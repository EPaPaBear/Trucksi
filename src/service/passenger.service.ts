
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { DriverDTO } from 'src/dto/driverdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PassengerDTO } from 'src/dto/passengerdto';

@Injectable({
  providedIn: 'root'
})

export class PassengerService extends AbstractService<PassengerDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'passenger';
  }

  getAllById(passengerDTO: PassengerDTO): Observable<PassengerDTO[]> {
    return this.http.post<PassengerDTO[]>('http://localhost:8080/' + this.type + '/getallbydriver', passengerDTO);
  }
}


