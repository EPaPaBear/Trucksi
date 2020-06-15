package it.contrader.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	public enum Usertype {
		ADMIN, USER, DRIVER, PASSENGER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;

	private Usertype usertype; 
	
	//mappedBy -> creo una connessione bidirezionale tra user e driver
	@OneToOne(mappedBy = "user", cascade = CascadeType.REFRESH)   
	private Driver driver;  
	
	//mappedBy -> creo una connessione bidirezionale tra user e driver
	@OneToOne(mappedBy = "user", cascade = CascadeType.REFRESH)  
	private Passenger passenger;   
	
	private boolean active = true;
 	
}
