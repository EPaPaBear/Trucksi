package it.contrader.dto;


import it.contrader.model.Hystorytravel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CityDTO {

	private Long id;

	private String cityname;
	
	private Hystorytravel ht;
	
}
