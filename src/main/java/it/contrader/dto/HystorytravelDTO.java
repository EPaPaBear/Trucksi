package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HystorytravelDTO {

	private Long idt;
	
	private String nometeam;
	
	private String descrizione;
	
	private String numeroutenti;
	
	private String numeroteam;
}
