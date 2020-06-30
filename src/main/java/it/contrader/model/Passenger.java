package it.contrader.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.dto.TruckDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIdentityInfo(scope = Passenger.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@ToString(exclude = {"user","truck"}) 
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
	
	@ManyToOne(cascade = CascadeType.REFRESH) 
	@JoinColumn(name = "idTruck", referencedColumnName = "id") 
	private Truck truck ;
	
}
