package it.contrader.dto;

import java.sql.Time;


import it.contrader.model.Travel;
import it.contrader.model.Truck;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HystorytravelDTO {

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
	private TravelDTO travel;
	private TruckDTO truck;
}
