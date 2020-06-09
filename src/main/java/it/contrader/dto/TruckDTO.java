package it.contrader.dto;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TruckDTO {

	private Long id;

	private int howManyPeople;

	private String licensePlate;

	private int peopleBooking;

}
