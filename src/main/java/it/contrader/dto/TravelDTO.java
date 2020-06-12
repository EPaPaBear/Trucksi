package it.contrader.dto;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import it.contrader.model.Passenger;
import it.contrader.model.Truck;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TravelDTO {
	private Long id;
	private LocalDateTime traveldate;
	private Passenger passenger;
	private Truck truck;
	//@ManyToOne
	//private Historytravel history;
}
