import { Time } from '@angular/common';
import { TruckDTO } from './truckdto';

export class HystorytravelDTO {

    id: number;
    nometeam: string;
    descrizione: string;
    numeroutent: string;
    numeroteam: string;
    timedeparture: Time;
    timearrival: Time;
    truckDTO: TruckDTO;
    // mancano travel e city;
}