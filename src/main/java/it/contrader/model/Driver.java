package it.contrader.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

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
@ToString(exclude = {"truckList","user"})
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String surname;
	
	@Column(unique = true)
	private String driverLicense;
	
	private String phone; 
	
	private int age; 
	
	
	@OneToMany(cascade = CascadeType.REFRESH)	
	@JoinColumn(name = "user_id" )
	private List<Truck> truckList; 

	//cascade -> propaga tutte le operazione dal padre a tutti i figli(tutte le tabbelle collegate)
	//joinColumn -> va definito dove si vuole la chiave esterna
		//name -> nome della colonna dentro driver
		//referencedColumnName -> colonna dalla quale prendere il valore di user, per metterla in name
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id" )
	private User user;
	
	 

}
