package it.contrader.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToMany(mappedBy = "driver", cascade = CascadeType.MERGE) 	 
	private List<Truck> truckList;
	
	//cascade -> propaga tutte le operazione dal padre a tutti i figli(tutte le tabbelle collegate)
	//joinColumn -> va definito dove si vuole la chiave esterna
		//name -> nome della colonna dentro driver
		//referencedColumnName -> colonna dalla quale prendere il valore di user, per metterla in name
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idUser", referencedColumnName = "id")  
	private User user;
	
	 

}
