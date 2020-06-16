package it.contrader.model;

import java.util.List;

import javax.persistence.*;

import it.contrader.dto.TruckDTO;
import it.contrader.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
	
	@OneToMany(mappedBy = "driver", cascade = CascadeType.REFRESH)	 
	private List<TruckDTO> truckList;
	
	//cascade -> propaga tutte le operazione dal padre a tutti i figli(tutte le tabbelle collegate)
	//joinColumn -> va definito dove si vuole la chiave esterna
		//name -> nome della colonna dentro driver
		//referencedColumnName -> colonna dalla quale prendere il valore di user, per metterla in name
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idUser", referencedColumnName = "id")  
	private UserDTO user;
	
	 

}
