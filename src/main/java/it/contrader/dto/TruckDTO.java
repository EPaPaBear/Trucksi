package it.contrader.dto;

import it.contrader.model.Driver;
import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TruckDTO {

	private Long id;

	private String licensePlate;

	private Driver driver;

}
