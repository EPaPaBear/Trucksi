package it.contrader.model;

import javax.persistence.*;

import it.contrader.dto.TruckDTO;
import it.contrader.dto.UserDTO;
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
	@JoinColumn(name = "idTruck", referencedColumnName = "id") 
	private Truck truck ;
	
}
