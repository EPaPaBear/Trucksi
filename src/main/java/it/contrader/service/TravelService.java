package it.contrader.service;

import it.contrader.converter.TravelConverter;
import it.contrader.dao.TravelDAO;
import it.contrader.dto.TravelDTO;
import it.contrader.model.Travel;

 
public class TravelService extends AbstractService<Travel, TravelDTO> {
	public TravelService(){
		this.dao = new TravelDAO();
		this.converter = new TravelConverter();
	}
}
