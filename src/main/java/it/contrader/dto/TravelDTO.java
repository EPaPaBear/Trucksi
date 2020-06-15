package it.contrader.dto;

import java.sql.Time;
import java.time.LocalDateTime;

import it.contrader.model.City;
import it.contrader.model.Passenger;
import it.contrader.model.Truck;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelDTO {

	private Long id;
	
	private String nometeam;
	
	private String descrizione;
	private String numeroutenti;
	private String numeroteam;
//	private Time timedeparture;
//	private Time timearrival;
	private City citydeparture;
	private City cityarrive;
	private User user;
	private Truck truck;
	private Passenger passenger;
	//private LocalDateTime date;
}
