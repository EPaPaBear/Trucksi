package it.contrader.service;

import it.contrader.converter.TruckConverter;
import it.contrader.dao.TruckDAO;
import it.contrader.dto.TruckDTO;
import it.contrader.model.Truck;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class TruckService extends AbstractService<Truck, TruckDTO> { 
	
	//Istanzio DAO  e Converter specifici.
	public TruckService(){
		this.dao = new TruckDAO();
		this.converter = new TruckConverter();
	}
	

}
