
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { DriverDTO } from 'src/dto/driverdto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class DriverService extends AbstractService<DriverDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'driver';
  }

  getAllById(driverDTO: DriverDTO): Observable<DriverDTO[]> {
    return this.http.post<DriverDTO[]>('http://localhost:8080/' + this.type + '/getallbydriver', driverDTO);
  }
}


