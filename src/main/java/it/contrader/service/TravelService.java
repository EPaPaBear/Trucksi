package it.contrader.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.dto.TravelDTO;
import it.contrader.model.Travel;
import it.contrader.converter.TravelConverter;
import it.contrader.dao.TravelRepository;

@Service
public class TravelService extends AbstractService<Travel, TravelDTO> {

	@Autowired
	private TravelConverter converter;
	@Autowired
	private TravelRepository repository;


}
