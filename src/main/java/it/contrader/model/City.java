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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString(exclude= {"ht"})
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String cityname;
	//@ManyToOne(cascade=CascadeType.MERGE)
	//@JoinColumn(name="idhystorytravel", referencedColumnName="idt")
	//private Hystorytravel ht;
	@OneToOne(mappedBy = "city", cascade = CascadeType.MERGE)  
	private Hystorytravel ht; 
}
