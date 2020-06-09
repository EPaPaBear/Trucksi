package it.contrader.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import it.contrader.converter.TruckConverter;
import it.contrader.dao.TruckRepository;
import it.contrader.dto.TruckDTO;
import it.contrader.model.Truck;

@Service
public class TruckService extends AbstractService<Truck, TruckDTO> {

	@Autowired
	private TruckConverter converter;
	@Autowired
	private TruckRepository repository;

	//public TruckDTO findByUsernameAndPassword(String username, String password) {
	//	return converter.toDTO(repository.findByUsernameAndPassword(username, password));
	//} 

}
