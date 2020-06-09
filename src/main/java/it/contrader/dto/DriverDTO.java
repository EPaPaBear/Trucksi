package it.contrader.dto;

import javax.persistence.ManyToOne;

import it.contrader.model.User;
import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DriverDTO {

	private Long id;

	private String name;
	
	private String surname;
	
	private String driverLicense;
	
	private String phone; 
	
	@ManyToOne
	private User user;

}
