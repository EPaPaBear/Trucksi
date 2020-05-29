package it.contrader.service;

import it.contrader.converter.TravelConverter;
import it.contrader.dao.TravelDao;
import it.contrader.dto.TravelDTO;
import it.contrader.model.Travel;


public class TravelService extends AbstractService<Travel, TravelDTO> {
	public TravelService(){
		this.dao = new TravelDao();
		this.converter = new TravelConverter();
	}
}
