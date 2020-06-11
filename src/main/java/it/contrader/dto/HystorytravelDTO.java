package it.contrader.dto;

import java.sql.Time;

import it.contrader.model.City;
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
	private City citydeparture;
	private City cityarrive;
}
