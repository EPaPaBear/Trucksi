package it.contrader.dto;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TravelDTO {
	private int id;
	private int idpassenger;
	private int idtruck;
	private int idhistory;
	Date travelDate = new Date();
	
}
