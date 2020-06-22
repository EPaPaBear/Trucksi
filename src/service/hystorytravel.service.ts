import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HystorytravelDTO } from 'src/dto/hystorytraveldto';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class HystorytravelService extends AbstractService<HystorytravelDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'hystorytravel';
  }

  getAllById(hystorytravelDTO: HystorytravelDTO): Observable<HystorytravelDTO[]> {
    return this.http.get<HystorytravelDTO[]>('http://localhost:8080/' + this.type + '/getall');

  }

}
