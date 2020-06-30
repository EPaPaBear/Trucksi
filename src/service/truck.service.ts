
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { DriverDTO } from 'src/dto/driverdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TruckDTO } from 'src/dto/truckdto';

@Injectable({
  providedIn: 'root'
})

export class TruckService extends AbstractService<TruckDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'truck';
  }

  getAllByDriver(id: number): Observable<TruckDTO[]> {
    return this.http.get<TruckDTO[]>('http://localhost:8080/' + this.type + '/getallbydriver?id=' + id);
  }
}


