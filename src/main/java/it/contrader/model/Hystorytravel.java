package it.contrader.model;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

// @ToString(exclude= {"city"})
public class Hystorytravel {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idt;
	
	@Column(unique = true)
	
	private String nometeam;
	
	private String descrizione;
	
	private String numeroutenti;
	
	private String numeroteam;
	
	private Time timedeparture;

	private Time timearrival;

	@OneToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name = "idcitydeparture", referencedColumnName = "id")  
	private City citydeparture;
	@OneToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name = "idcityarrive", referencedColumnName = "id")  
	private City cityarrive;
	@OneToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name = "iduser", referencedColumnName = "id")  
	private User user;
	@OneToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name = "idtruck", referencedColumnName = "id")  
	private Truck truck;

}
