package it.contrader.service;

import it.contrader.converter.HystorytravelConverter;
import it.contrader.dao.HystorytravelDAO;
import it.contrader.dto.HystorytravelDTO;
import it.contrader.model.Hystorytravel;

public class HystorytravelService extends AbstractService<Hystorytravel, HystorytravelDTO> {
	public HystorytravelService(){
		this.dao = new HystorytravelDAO();
		this.converter = new HystorytravelConverter();
	}
}
