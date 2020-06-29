
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { CityDTO } from '../dto/citydto';

@Injectable({
  providedIn: 'root'
})

export class CityService extends AbstractService<CityDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'city';
  }

}


