package it.contrader.dto;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TravelDTO {

	private String citydeparture;
	private String timedeparture;
	private String arrivalcity;
	private String arrivaltime;
	private String departuredate;
	private String arrivaldate;
	
}
