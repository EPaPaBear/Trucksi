package it.contrader.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class DriverDTO {

	private long id;
	
	private String name;
	
	private String surname;
	
	private String driverLicense;
	
	private String phone; 
	
	private int age; 
	
	private List<TruckDTO> truckList;  
	
	private UserDTO user;
	

}
