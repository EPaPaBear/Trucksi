package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CityConverter;
import it.contrader.dao.CityRepository;
import it.contrader.dto.CityDTO;
import it.contrader.dto.TruckDTO;
import it.contrader.model.City;
import it.contrader.model.Truck;
@Service
public class CityService extends AbstractService<City, CityDTO>{
	@Autowired
	private CityConverter converter;
	@Autowired
	private CityRepository repository;
	
	public City convertCityDTO(CityDTO cityDTO) {
		return converter.toEntity(cityDTO);
	}
	
}
