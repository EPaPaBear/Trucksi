package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.dao.CityRepository;
import it.contrader.dto.CityDTO;
import it.contrader.model.City;

@Service
public class CityService extends AbstractService<City, CityDTO> {

	@Autowired 
	private CityRepository repository; 
	
}
