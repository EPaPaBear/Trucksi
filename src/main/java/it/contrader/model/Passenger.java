package it.contrader.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String surname;
	
	private int age;
	
	private String phone;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "idUser", referencedColumnName = "id")  
	private User user;
	@ManyToOne(cascade = CascadeType.MERGE) 
	@JoinColumn(name = "idDriver", referencedColumnName = "id") 
	private Truck truck ;
	
}
