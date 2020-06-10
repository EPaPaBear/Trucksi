package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.converter.CityConverter;
import it.contrader.dao.CityRepository;
import it.contrader.dto.CityDTO;
import it.contrader.model.City;

public class CityService extends AbstractService<City, CityDTO>{
	@Autowired
	private CityConverter converter;
	@Autowired
	private CityRepository repository;
}
