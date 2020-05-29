package it.contrader.service;

import it.contrader.converter.CityConverter;
import it.contrader.dao.CityDAO;
import it.contrader.dao.DAO;
import it.contrader.dto.CityDTO;
import it.contrader.model.City;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */

public class CityService extends AbstractService<City, CityDTO> {

	//Istanzio DAO  e Converter specifici.
		public CityService(){
			this.dao = new CityDAO();
			this.converter = new CityConverter();
		}
}
