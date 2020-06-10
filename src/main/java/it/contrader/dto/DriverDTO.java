package it.contrader.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;

import it.contrader.model.Truck;
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
	
	private int age;  
	
	private List<Truck> truckList = new ArrayList<>(); 
	private User user;
	
	

}
