import { Time } from '@angular/common';
import { TruckDTO } from './truckdto';

export class HystorytravelDTO {

    id: number;
    nometeam: string;
    descrizione: string;
    numeroutent: string;
    numeroteam: string;
    timedeparture: string;
    timearrival: string;
    truckDTO: TruckDTO;
    // mancano travel e city;
}