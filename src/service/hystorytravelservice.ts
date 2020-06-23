import { AbstractService } from './abstractservice';
import { HystorytravelDTO } from 'src/dto/hystorytraveldto';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({providedIn: 'root'})
export class HystorytravelService extends AbstractService<HystorytravelDTO> {

    constructor (http: HttpClient){
        super(http);
        this.type = 'hystorytravel';
    }
    
}