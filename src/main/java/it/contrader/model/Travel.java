package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private int id;
	@Column(unique = true)
	private int idpassenger;
	private int idtruck;
	private int idhistory;
	Date  traveldate = new Date();
	@ManyToOne
	private Passenger passenger;
	@ManyToOne
	private Truck truck;
}
