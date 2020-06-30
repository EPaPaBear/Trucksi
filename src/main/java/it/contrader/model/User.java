package it.contrader.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(scope = User.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@ToString(exclude = {"driver","passenger"})
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
	
	
	@Column(nullable = false,columnDefinition = "BOOLEAN")
	private boolean active = true;
	
}
