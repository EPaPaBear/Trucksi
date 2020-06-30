package it.contrader.model;

import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity 
@JsonIdentityInfo(scope = Driver.class, generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
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
	private List<Truck> truckList; 

	//cascade -> propaga tutte le operazione dal padre a tutti i figli(tutte le tabbelle collegate)
	//joinColumn -> va definito dove si vuole la chiave esterna
		//name -> nome della colonna dentro driver
		//referencedColumnName -> colonna dalla quale prendere il valore di user, per metterla in name
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "user_id" )
	private User user;
	
	 

}
