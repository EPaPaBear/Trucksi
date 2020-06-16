package it.contrader.model;

import javax.persistence.*;

import it.contrader.dto.DriverDTO;
import it.contrader.dto.PassengerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
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
	private DriverDTO driver;  
	
	//mappedBy -> creo una connessione bidirezionale tra user e driver
	@OneToOne(mappedBy = "user", cascade = CascadeType.REFRESH)  
	private PassengerDTO passenger;   
	
	@Column(nullable = false,columnDefinition = "BOOLEAN")
	private boolean active = true;
	
}
