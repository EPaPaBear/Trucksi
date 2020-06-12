package it.contrader.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Travel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	
	@DateTimeFormat
	LocalDateTime  traveldate;
	@OneToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name = "idpassenger", referencedColumnName = "id")
	private Passenger passenger;
	@OneToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name = "idtruck", referencedColumnName = "id")
	private Truck truck;
	
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "idcity", referencedColumnName = "id")
	private City city;
	
	
	//@ManyToOne
	//private Historytravel history;

}