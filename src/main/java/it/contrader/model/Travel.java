package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;


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
	Date  traveldate;
	@ManyToOne
	private Passenger passenger;
	@ManyToOne
	private Truck truck;
	//@ManyToOne
	//private Historytravel history;
	
	

}
