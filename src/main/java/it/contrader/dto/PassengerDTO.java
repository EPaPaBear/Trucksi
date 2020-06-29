package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PassengerDTO {

	private long id;
	
	private String name;
	
	private String surname;
	
	private int age;
	
	private String phone;
	
	private UserDTO user;
	
	private TruckDTO truck ;
	

}
