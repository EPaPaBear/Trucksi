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
    //mancano travel e city;
}

/**
 * 
 * public class HystorytravelDTO {

	private Long idt;
	
	private String nometeam;
	
	private String descrizione;
	
	private String numeroutenti;
	
	private String numeroteam;
	private Time timedeparture;
	private Time timearrival;
//	private City citydeparture;
//	private City cityarrive;
//	private User user;
//	private Truck truck;
	private Travel travel;
	private Truck truck;
}

 */