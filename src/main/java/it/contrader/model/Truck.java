package it.contrader.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import it.contrader.dto.DriverDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString(exclude = {"driver"})
public class Truck{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String licensePlate;
	
	private String model;
	
	/*
	@ManyToOne(cascade = CascadeType.REFRESH) 
	@JoinColumn(name = "idriver", referencedColumnName = "id") 
	private DriverDTO driver ;
	*/
	
	@ManyToOne(cascade = CascadeType.REFRESH) 
	@JoinColumn(name = "idriver", referencedColumnName = "id") 
	private Driver driver ;
	
	
	

}
